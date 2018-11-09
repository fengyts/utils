package ng.bayue.generator.types;

public final class JavaType {

	public static final String OBJECT = "Object";

	public static final String STRING = "String";
	public static final String BIGDECIMAL = "BigDecimal";

	public static final String DATE_UTIL = "Date";
	public static final String DATE_SQL = "Date";
	
	public static final String LIST = "List";
	public static final String ARRAYLIST = "ArrayList";
	public static final String LINKEDLIST = "LinkedList";
	public static final String MAP = "Map";
	public static final String HASHMAP = "HashMap";
	public static final String SORTEDMAP = "SortedMap";
	public static final String TREEMAP = "TreeMap";
	
	
	public static final String BYTE_ARRAY = "byte[]";

	/**
	 * java基础数据类型
	 * 
	 * @author lenovopc
	 *
	 */
	public static final class BasicType {
		public static final String BYTE = "byte";
		public static final String SHORT = "short";
		public static final String INT = "int";
		public static final String LONG = "long";
		public static final String FLOAT = "float";
		public static final String DOUBLE = "double";
		public static final String CHAR = "char";
		public static final String BOOLEAN = "boolean";
	}

	/**
	 * java基础数据类型的封装类型
	 * 
	 * @author lenovopc
	 *
	 */
	public static final class BasicTypePackaging {
		public static final String BYTE = "Byte";
		public static final String SHORT = "Short";
		public static final String INTEGER = "Integer";
		public static final String LONG = "Long";
		public static final String FLOAT = "Float";
		public static final String DOUBLE = "Double";
		public static final String CHARACTER = "Character";
		public static final String BOOLEAN = "Boolean";
	}

	private JavaType() {
	}

}
