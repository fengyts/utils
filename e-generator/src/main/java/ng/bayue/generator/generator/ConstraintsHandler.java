package ng.bayue.generator.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ng.bayue.generator.constants.ColumnConstraintType;
import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.model.info.TableConstraints;
import ng.bayue.generator.utils.JdbcUtil;

public class ConstraintsHandler {

	private static boolean isPK(String constraintsType) {
		return ColumnConstraintType.PRIMAY_KEY.typeName.equalsIgnoreCase(constraintsType);
	}

	private static boolean isUK(String constraintsType) {
		return ColumnConstraintType.UNIQUE.typeName.equalsIgnoreCase(constraintsType);
	}

	public static List<TableConstraints> getConstraints(String dbSchema, boolean isAllTables, String... tableNames) {
		List<TableConstraints> uks = new ArrayList<TableConstraints>();
		try {
			boolean isOnlyUK = true;
			// boolean isAllTables = true; // 预留字段, 是否所有表, 会根据tableNames自动判断
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

	public static void getConstraintsStatistics() {
	}

}
