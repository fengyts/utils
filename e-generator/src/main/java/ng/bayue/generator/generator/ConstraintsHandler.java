package ng.bayue.generator.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ng.bayue.generator.constants.ColumnConstraintType;
import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.constants.DbInformationSchemaSql.SqlTableColumnDetailSelectMapper;
import ng.bayue.generator.constants.DbInformationSchemaSql.SqlTableColumnDetailSelectMapper.SC;
import ng.bayue.generator.constants.DbInformationSchemaSql.SqlTableColumnDetailSelectMapper.STC;
import ng.bayue.generator.model.Column;
import ng.bayue.generator.model.ConstraintsInfo;
import ng.bayue.generator.model.TableInfo;
import ng.bayue.generator.model.info.TableConstraints;
import ng.bayue.generator.utils.JdbcUtil;

@Deprecated
@SuppressWarnings({"deprecation", "unused"})
public class ConstraintsHandler {

	private static boolean isPK(String constraintsType) {
		return ColumnConstraintType.PRIMAY_KEY.typeName.equalsIgnoreCase(constraintsType);
	}

	private static boolean isUK(String constraintsType) {
		return ColumnConstraintType.UNIQUE.typeName.equalsIgnoreCase(constraintsType);
	}

	/**
	 * 是否生成所有表, isAllTables参数仅仅是一个预留的标识, 真正影响是否生成所有表的是参数tableNames,若它不为空则标识为只生成指定表(哪怕指定isAllTables为true)。
	 * @param isAllTables
	 * @param tableNames
	 * @return
	 */
	private static boolean isAllTables(boolean isAllTables, String... tableNames) {
		if (null != tableNames && tableNames.length != 0) {
			return false;
		}
		return true;
	}

	public static List<TableConstraints> getConstraints(String dbSchema, boolean isAllTables, String... tableNames) {
		List<TableConstraints> uks = new ArrayList<TableConstraints>();
		try {
			boolean isOnlyUK = true;
			// boolean isAllTables = true; // 预留字段, 是否所有表, 会根据tableNames自动判断
			isAllTables = isAllTables(isAllTables, tableNames);
			final String sql = DbInformationSchemaSql.getSqlTableConstrains(dbSchema, isOnlyUK, isAllTables,
					tableNames);
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			TableConstraints constraint = null;
			// String pkConstraint = null;
			List<String> uniqueConstraints = null;
			Map<String, Object> tables = new HashMap<String, Object>();
			while (rs.next()) {
				String tableName = rs.getString(1);
				String constraintsName = rs.getString(2);
				String constraintsType = rs.getString(3);
				if (!tables.containsKey(tableName)) { // 新表
					// 保存上一张表信息
					if (null != constraint) {
						if (null != uniqueConstraints) {
							constraint.setUniqueConstraints(uniqueConstraints);
						}
						uks.add(constraint);
					}
					// 初始化新表信息
					tables.put(tableName, tableName);
					constraint = new TableConstraints();
					uniqueConstraints = new ArrayList<String>();
					constraint.setTableName(tableName);
					if (isPK(constraintsType)) {
						// pkConstraint = constraintsName;
						constraint.setPkConstraint(constraintsName);
					}
					if (isUK(constraintsType)) {
						uniqueConstraints.add(constraintsName);
					}
				} else {
					// if (isPK(constraintsType)) {
					// // pkConstraint = constraintsName;
					// constraint.setPkConstraint(constraintsName);
					// }
					if (isUK(constraintsType)) {
						uniqueConstraints.add(constraintsName);
					}
				}
			}
			// 保存最后一次遍历ResultSet后的表约束信息
			if (null != constraint) {
				if (null != uniqueConstraints) {
					constraint.setUniqueConstraints(uniqueConstraints);
				}
				uks.add(constraint);
			}
			JdbcUtil.close(conn, pstat, rs);
			return uks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uks;
	}

	public static List<TableInfo> getTableDetailInfo(String dbSchema, boolean isAllTables, String... tableNames) {
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
		try {
			isAllTables = isAllTables(isAllTables, tableNames);
			final String sql = DbInformationSchemaSql.getSqlTableColumnDetailInfo(dbSchema, isAllTables, tableNames);
			System.out.println(sql);
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			Set<String> tables = new LinkedHashSet<String>(); // 表名
			TableInfo table = null;
			List<Column> columns = null;
			ConstraintsInfo constraintsInfo = null;
			boolean isNewTable = true; // 是否下一张表
			while (rs.next()) {
				String tableName = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.TABLE_NAME));
				String columnName = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.COLUMN_NAME));
				String dataType = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.DATA_TYPE));
				// String columnKey =
				// rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.COLUMN_KEY));
				String columnDefault = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.COLUMN_DEFAULT));
				String columnComment = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SC.COLUMN_COMMENT));
				// String indexName =
				// rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SqlTableColumnDetailSelectMapper.SS.INDEX_NAME));
				// String nonUnique =
				// rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SqlTableColumnDetailSelectMapper.SS.NON_UNIQUE));
				// String seqInIndex =
				// rs.getString(SqlTableColumnDetailSelectMapper.getIndex(SqlTableColumnDetailSelectMapper.SS.SEQ_IN_INDEX));
				String constraintName = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(STC.CONSTRAINT_NAME));
				String constraintType = rs.getString(SqlTableColumnDetailSelectMapper.getIndex(STC.CONSTRAINT_TYPE));

				System.out.println(tableName + "-" + columnName + "-" + dataType + "-" + columnDefault + "-"
						+ columnComment + "-" + constraintName + "-" + constraintType);

				if (tables.contains(tableName)) {
					isNewTable = false;
					// 保存本列
					handleColumn(columns, columnName, dataType, columnDefault, columnComment);
				} else {
					isNewTable = true;
					tables.add(tableName);
					// 保存上一张表信息
					tableInfos.add(table);
					// 初始化新表
					table = new TableInfo();
					columns = new ArrayList<Column>();
					constraintsInfo = new ConstraintsInfo();

					// 保存本列
					handleColumn(columns, columnName, dataType, columnDefault, columnComment);
				}

			}
			JdbcUtil.close(conn, pstat, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableInfos;
	}

	/**
	 * @param columns
	 * @param columnName
	 * @param dataType
	 * @param columnDefault
	 * @param columnComment
	 */
	private static void handleColumn(List<Column> columns, String columnName, String dataType, String columnDefault,
			String columnComment) {
		Column column = new Column();
		column.setColumnName(columnName);
		column.setComment(columnComment);
		column.setDefaultValue(columnDefault);
		column.setJdbcTypeName(dataType);

		columns.add(column);
	}

}
