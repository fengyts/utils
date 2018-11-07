package ng.bayue.generator.types;

public final class JavaType {

	public static final String object = "Object";

	public static final String string_type = "String";
	public static final String bigdecimal_type = "BigDecimal";

	public static final String date_type_util = "Date";
	public static final String date_type_sql = "Date";

	/**
	 * java基础数据类型
	 * 
	 * @author lenovopc
	 *
	 */
	public static final class BasicType {
		public static final String byte_type = "byte";
		public static final String short_type = "short";
		public static final String int_type = "int";
		public static final String long_type = "long";
		public static final String float_type = "float";
		public static final String double_type = "double";
		public static final String char_type = "char";
		public static final String boolean_type = "boolean";
	}

	/**
	 * java基础数据类型的封装类型
	 * 
	 * @author lenovopc
	 *
	 */
	public static final class BasicTypePackaging {
		public static final String byte_type = "Byte";
		public static final String short_type = "Short";
		public static final String integer_type = "Integer";
		public static final String long_type = "Long";
		public static final String float_type = "Float";
		public static final String double_type = "Double";
		public static final String character_type = "Character";
		public static final String boolean_type = "Boolean";
	}

	private JavaType() {
	}

}
