package ng.bayue.generator.generator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.model.Column;
import ng.bayue.generator.model.ConstraintsInfo;
import ng.bayue.generator.model.PrimaryKeyInfo;
import ng.bayue.generator.model.TableInfo;
import ng.bayue.generator.model.UniqueKeyInfo;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.handler.GenericTypeHandler;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.StringUtils;

public class TableInfoHandler {

	private Context context;

	public TableInfoHandler(Context context) {
		this.context = context;
	}

	public static void main(String[] args) {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);

		Context context = new Context();
		TableInfoHandler handler = new TableInfoHandler(context);
		String tableNamePattern = "test_key";
		handler.getTableInfo(tableNamePattern);
	}

	public TableInfo getTableInfo(String tableNamePattern) {
		TableInfo info = new TableInfo();
		try {
			Connection conn = JdbcUtil.getConnection();
			DatabaseMetaData metaData = conn.getMetaData();
			String catalog = conn.getCatalog();
			String schema = conn.getSchema();

			Param param = new Param();
			param.setCatalog(catalog);
			param.setSchemaPattern(schema);
			param.setTableNamePattern(tableNamePattern);
			param.setColumnNamePattern("%");

			List<Column> columns = getColumns(metaData, param);

			getPKInfo(metaData, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	private List<Column> getColumns(DatabaseMetaData metaData, Param param) throws SQLException {
		List<Column> columns = new ArrayList<Column>();
		// DatabaseMetaData metaData = conn.getMetaData();
		ResultSet rs = metaData.getColumns(param.getCatalog(), param.getSchemaPattern(), param.getTableNamePattern(),
				param.getColumnNamePattern());

		GenericTypeHandler handler = new GenericTypeHandler();
		Column column;
		while (rs.next()) {
			column = new Column();
			int jdbcType = rs.getInt("DATA_TYPE");
			int columnSize = rs.getInt("COLUMN_SIZE");
			String columnName = rs.getString("COLUMN_NAME");
			// boolean nullAble = rs.getInt("NULLABLE") ==
			// DatabaseMetaData.columnNullable;
			// int decimalDigits = rs.getInt("DECIMAL_DIGITS");
			String remarks = rs.getString("REMARKS");
			String columnDefaultVal = rs.getString("COLUMN_DEF");
			// String isAutoIncrement = rs.getString("IS_AUTOINCREMENT");
			// String isGeneratedColumn = rs.getString("IS_GENERATEDCOLUMN");

			String jdbcTypeName = GenericJdbcTypeMapper.getJdbcTypeName(jdbcType);
			String javaTypeName = handler.getJavaTypeName(jdbcTypeName);
			// System.out.println(javaType + "-" + jdbcTypeName + "-" + jdbcType
			// + "-" + columnSize + "-" + columnName
			// + "-" + nullAble + "-" + decimalDigits + "-" + remarks + "-" +
			// columnDefaultVal + "-"
			// + isAutoIncrement + "-" + "-" + isGeneratedColumn);
			column.setColumnName(columnName);
			column.setDefaultValue(columnDefaultVal);
			column.setComment(remarks);
			column.setJdbcTypeName(jdbcTypeName);
			column.setJavaPropertyType(javaTypeName);
			column.setJavaPropertyName(StringUtils.toHumpFormat(columnName));

			columns.add(column);
		}
		rs.close();
		return columns;
	}

	private ConstraintsInfo getConstraintInfo(DatabaseMetaData metaData, Param param) {
		ConstraintsInfo info = new ConstraintsInfo();

		return info;
	}

	private PrimaryKeyInfo getPKInfo(DatabaseMetaData metaData, Param param) throws SQLException {
		PrimaryKeyInfo info = new PrimaryKeyInfo();
		ResultSet primaryKeys = metaData.getPrimaryKeys(param.getCatalog(), param.getSchemaPattern(),
				param.getTableNamePattern());
		ResultSetMetaData pkMeta = primaryKeys.getMetaData();
		int colCount = pkMeta.getColumnCount();
		String colName = "";
		for (int i = 1; i <= colCount; i++) {
			colName += pkMeta.getColumnName(i) + "——";
		}
		List<Column> columns = new ArrayList<Column>();
		Column column;
		while (primaryKeys.next()) {
			column = new Column();
			String columnName = primaryKeys.getString("COLUMN_NAME");
			int keySeq = primaryKeys.getInt("KEY_SEQ");
			System.out.println(columnName+"——" + keySeq);
			column.setColumnName(columnName);
			
		}
		System.out.println(colName);
		primaryKeys.close();
		return info;
	}

	private UniqueKeyInfo getUniqueInfo(DatabaseMetaData metaData, Param param) {
		UniqueKeyInfo info = new UniqueKeyInfo();

		return info;
	}

	private static class Param {
		private String catalog;
		private String schemaPattern;
		private String tableNamePattern;
		private String columnNamePattern;

		public String getCatalog() {
			return catalog;
		}

		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		public String getSchemaPattern() {
			return schemaPattern;
		}

		public void setSchemaPattern(String schemaPattern) {
			this.schemaPattern = schemaPattern;
		}

		public String getTableNamePattern() {
			return tableNamePattern;
		}

		public void setTableNamePattern(String tableNamePattern) {
			this.tableNamePattern = tableNamePattern;
		}

		public String getColumnNamePattern() {
			return columnNamePattern;
		}

		public void setColumnNamePattern(String columnNamePattern) {
			this.columnNamePattern = columnNamePattern;
		}

	}

}
