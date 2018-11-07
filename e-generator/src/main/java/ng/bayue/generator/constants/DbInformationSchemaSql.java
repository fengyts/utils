package ng.bayue.generator.constants;

import com.mysql.jdbc.StringUtils;

public final class DbInformationSchemaSql {

	private static final String DB_INFO_SCHEMA_NAME = "information_schema";

	// "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT,COLUMN_KEY FROM
	// information_schema.columns WHERE table_schema='"+ schema + "' and
	// table_name = '" + tableName + "' ";
	private static String SQL_COLUMN_INFO = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY, COLUMN_DEFAULT "
			+ "FROM information_schema.columns " + "WHERE table_schema='{0}' AND table_name = '{1}'; ";

	private String SQL_KEY_INFO = "";

	public static String getSqlColumnInfo(String schema, String tableName) {
		if (StringUtils.isNullOrEmpty(schema) || StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		return SQL_COLUMN_INFO.replace("{0}", schema).replace("{1}", tableName);
	}

}
