package ng.bayue.generator.constants;

public final class DbInformationSchemaConstant {

	private static final String DB_INFO_SCHEMA_NAME = "information_schema";

	// "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT,COLUMN_KEY FROM
	// information_schema.columns WHERE table_schema='"+ schema + "' and
	// table_name = '" + tableName + "' ";
	private String SQL_COLUMN_INFO = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY, COLUMN_DEFAULT "
			+ "FROM information_schema.columns "
			+ "WHERE table_schema='{0}' AND table_name = '{1}'; ";

	private String SQL_KEY_INFO = "";

	public static String getSql(String schema, String tableName) {
		return "";
	}

}
