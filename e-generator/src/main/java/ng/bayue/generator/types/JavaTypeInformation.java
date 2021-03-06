package ng.bayue.generator.types;

import ng.bayue.generator.utils.StringUtils;

public final class JavaTypeInformation {

	public static final JavaTypeInformation OBJECT = new JavaTypeInformation(Object.class.getName());

	private String packageName;
	private String javaTypeShort;
	/** javaTypeFully = packageName + "." + javaTypeShort */
	private String javaTypeFully;
	private boolean isJavaLangPackage = true;
	private boolean isArray = false;

	public JavaTypeInformation(String javaTypeNameFully) {
		if (StringUtils.isBlank(javaTypeNameFully)) {
			throw new NullPointerException();
		}
		this.javaTypeFully = javaTypeNameFully;
		if (CommonJavaType.BYTE_ARRAY.equalsIgnoreCase(javaTypeNameFully) || javaTypeNameFully.endsWith("]")) {
			this.isArray = true;
			this.javaTypeShort = javaTypeNameFully;
		} else {
			int lastPoint = javaTypeNameFully.lastIndexOf(".");
			String packageName = javaTypeNameFully.substring(0, lastPoint);
			String javaTypeNameShort = javaTypeNameFully.substring(lastPoint + 1);
			this.javaTypeShort = javaTypeNameShort;
			this.packageName = packageName;
			this.isJavaLangPackage = CommonJavaType.PACKAGE_LANG.equals(packageName);
		}
	}

	public static JavaTypeInformation newInstance(String javaTypeNameFully) {
		JavaTypeInformation jti = new JavaTypeInformation(javaTypeNameFully);
		return jti;
	}

	public boolean isBasicJavaType() {
		final String[] basicJavaPackagingType = BasicTypePackaging.BASIC_JAVATYPE_PACKAGING_ARRAY;
		for (int i = 0; i < 8; i++) {
			if (basicJavaPackagingType[i].equals(javaTypeShort)) {
				return true;
			}
		}
		return false;
	}

	public String getJavaTypeShort() {
		return javaTypeShort;
	}

	public void setJavaTypeShort(String javaTypeShort) {
		this.javaTypeShort = javaTypeShort;
	}

	public String getJavaTypeFully() {
		return javaTypeFully;
	}

	public void setJavaTypeFully(String javaTypeFully) {
		this.javaTypeFully = javaTypeFully;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isJavaLangPackage() {
		return isJavaLangPackage;
	}

	public void setJavaLangPackage(boolean isJavaLangPackage) {
		this.isJavaLangPackage = isJavaLangPackage;
	}

	public boolean isArray() {
		return isArray;
	}

	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}

	public static class CommonJavaType {
		public static final String PACKAGE_LANG = "java.lang";
		public static final String PACKAGE_UTIL = "java.util";
		public static final String PACKAGE_MATH = "java.math";
		public static final String PACKAGE_SQL = "java.sql";

		public static final String OBJECT = "java.lang.Object";
		public static final String STRING = "java.lang.String";
		
		public static final String BIGDECIMAL = "java.math.BigDecimal";

		/** java.util.Date */
		public static final String DATE_UTIL = "java.util.Date";
		/** java.sql.Date */
		public static final String DATE_SQL = "java.sql.Date";

		/** java.util.Arrays */
		public static final String ARRAYS = "java.util.Arrays";

		public static final String LIST = "java.util.List";
		public static final String ARRAYLIST = "java.util.ArrayList";
		public static final String LINKEDLIST = "java.util.LinkedList";

		public static final String MAP = "java.util.Map";
		public static final String HASHMAP = "java.util.HashMap";
		public static final String SORTEDMAP = "java.util.SortedMap";
		public static final String TREEMAP = "java.util.TreeMap";
		public static final String LINKEDHASHMAP = "java.util.LinkedHashMap";

		public static final String SET = "java.util.Set";
		public static final String HASHSET = "java.util.HashSet";
		public static final String TREESET = "java.util.TreeSet";
		public static final String LINKEDHASHSET = "java.util.LinkedHashSet";

		public static final String BYTE_ARRAY = "byte[]";

	}

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

		public static final String[] BASIC_JAVATYPE_ARRAY = { "byte", "short", "int", "long", "float", "double", "char",
				"boolean" };
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

		public static final String[] BASIC_JAVATYPE_PACKAGING_ARRAY = { BYTE, SHORT, INTEGER, LONG, FLOAT, DOUBLE,
				CHARACTER, BOOLEAN };
	}

}
