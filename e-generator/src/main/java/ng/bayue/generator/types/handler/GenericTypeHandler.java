package ng.bayue.generator.types.handler;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ng.bayue.generator.types.GenericJdbcType;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.JavaTypeInformation;
import ng.bayue.generator.utils.StringUtils;

public class GenericTypeHandler implements JdbcTypeResovle {

	private static Map<Integer, JdbcTypeInformation> typeMap;

	static {
		genericTypeMap();
	}

	public GenericTypeHandler() {
	}

	private static void genericTypeMap() {
		typeMap = new HashMap<Integer, JdbcTypeInformation>();

		typeMap.put(Types.ARRAY, newJdbcTypeInfoInstance(GenericJdbcType.ARRAY, Object.class.getName()));
		typeMap.put(Types.BIGINT, newJdbcTypeInfoInstance(GenericJdbcType.BIGINT, Long.class.getName()));
		typeMap.put(Types.BINARY, newJdbcTypeInfoInstance(GenericJdbcType.BINARY, Long.class.getName()));
		typeMap.put(Types.BIT, newJdbcTypeInfoInstance(GenericJdbcType.BIT, Boolean.class.getName()));
		typeMap.put(Types.BLOB,
				newJdbcTypeInfoInstance(GenericJdbcType.BLOB, JavaTypeInformation.CommonJavaType.BYTE_ARRAY));
		typeMap.put(Types.BOOLEAN, newJdbcTypeInfoInstance(GenericJdbcType.BOOLEAN, Boolean.class.getName()));
		typeMap.put(Types.CHAR, newJdbcTypeInfoInstance(GenericJdbcType.CHAR, String.class.getName()));
		typeMap.put(Types.CLOB, newJdbcTypeInfoInstance(GenericJdbcType.CLOB, String.class.getName()));
		typeMap.put(Types.DATALINK, newJdbcTypeInfoInstance(GenericJdbcType.DATALINK, Object.class.getName()));
		typeMap.put(Types.DATE, newJdbcTypeInfoInstance(GenericJdbcType.DATE, Date.class.getName()));
		typeMap.put(Types.DECIMAL, newJdbcTypeInfoInstance(GenericJdbcType.DECIMAL, BigDecimal.class.getName()));
		typeMap.put(Types.DISTINCT, newJdbcTypeInfoInstance(GenericJdbcType.DISTINCT, Object.class.getName()));
		typeMap.put(Types.DOUBLE, newJdbcTypeInfoInstance(GenericJdbcType.DOUBLE, Double.class.getName()));
		typeMap.put(Types.FLOAT, newJdbcTypeInfoInstance(GenericJdbcType.FLOAT, Float.class.getName()));
		typeMap.put(Types.INTEGER, newJdbcTypeInfoInstance(GenericJdbcType.INTEGER, Integer.class.getName()));
		typeMap.put(Types.JAVA_OBJECT, newJdbcTypeInfoInstance(GenericJdbcType.JAVA_OBJECT, Object.class.getName()));
		typeMap.put(Types.LONGNVARCHAR, newJdbcTypeInfoInstance(GenericJdbcType.LONGNVARCHAR, String.class.getName()));
		typeMap.put(Types.LONGVARBINARY,
				newJdbcTypeInfoInstance(GenericJdbcType.LONGVARBINARY, JavaTypeInformation.CommonJavaType.BYTE_ARRAY));
		typeMap.put(Types.LONGVARCHAR, newJdbcTypeInfoInstance(GenericJdbcType.LONGVARCHAR, String.class.getName()));
		typeMap.put(Types.NCHAR, newJdbcTypeInfoInstance(GenericJdbcType.NCHAR, String.class.getName()));
		typeMap.put(Types.NCLOB, newJdbcTypeInfoInstance(GenericJdbcType.NCLOB, String.class.getName()));
		typeMap.put(Types.NVARCHAR, newJdbcTypeInfoInstance(GenericJdbcType.NVARCHAR, String.class.getName()));
		typeMap.put(Types.NULL, newJdbcTypeInfoInstance(GenericJdbcType.NULL, Object.class.getName()));
		typeMap.put(Types.NUMERIC, newJdbcTypeInfoInstance(GenericJdbcType.NUMERIC, BigDecimal.class.getName()));
		typeMap.put(Types.OTHER, newJdbcTypeInfoInstance(GenericJdbcType.OTHER, Object.class.getName()));
		typeMap.put(Types.REAL, newJdbcTypeInfoInstance(GenericJdbcType.REAL, Float.class.getName()));
		typeMap.put(Types.REF, newJdbcTypeInfoInstance(GenericJdbcType.REF, Object.class.getName()));
		typeMap.put(Types.SMALLINT, newJdbcTypeInfoInstance(GenericJdbcType.SMALLINT, Short.class.getName()));
		typeMap.put(Types.STRUCT, newJdbcTypeInfoInstance(GenericJdbcType.STRUCT, Object.class.getName()));
		typeMap.put(Types.TIME, newJdbcTypeInfoInstance(GenericJdbcType.TIME, Date.class.getName()));
		typeMap.put(Types.TIMESTAMP, newJdbcTypeInfoInstance(GenericJdbcType.TIMESTAMP, Date.class.getName()));
		typeMap.put(Types.TINYINT, newJdbcTypeInfoInstance(GenericJdbcType.TINYINT, Byte.class.getName()));
		typeMap.put(Types.VARBINARY,
				newJdbcTypeInfoInstance(GenericJdbcType.VARBINARY, JavaTypeInformation.CommonJavaType.BYTE_ARRAY));
		typeMap.put(Types.VARCHAR, newJdbcTypeInfoInstance(GenericJdbcType.TINYINT, String.class.getName()));

	}

	public static String getJavaTypeName(String jdbcTypeName) {
		if (StringUtils.isBlank(jdbcTypeName)) {
			return JavaTypeInformation.CommonJavaType.OBJECT;
		}
		final String jt = jdbcTypeName.toUpperCase();
		final int type = GenericJdbcTypeMapper.getJdbcType(jt);
		final JdbcTypeInformation jdbcTypeInformation = typeMap.get(type);
		return null == jdbcTypeInformation ? JavaTypeInformation.CommonJavaType.OBJECT
				: jdbcTypeInformation.getJavaTypeInfo().getJavaTypeNameShort();
	}

	@Override
	public String resovle(String jdbcTypeName) {
		return getJavaTypeName(jdbcTypeName);
	}

	private static JdbcTypeInformation newJdbcTypeInfoInstance(String jdbcTypeName, String javaTypeClassNameFully) {
		return new JdbcTypeInformation(jdbcTypeName, new JavaTypeInformation(javaTypeClassNameFully));
	}

	public static class JdbcTypeInformation {
		private String jdbcType;
		private JavaTypeInformation javaTypeInfo;

		public JdbcTypeInformation(String jdbcType, JavaTypeInformation javaTypeInfo) {
			this.jdbcType = jdbcType;
			this.javaTypeInfo = javaTypeInfo;
		}

		public String getJdbcType() {
			return jdbcType;
		}

		public void setJdbcType(String jdbcType) {
			this.jdbcType = jdbcType;
		}

		public JavaTypeInformation getJavaTypeInfo() {
			return javaTypeInfo;
		}

		public void setJavaTypeInfo(JavaTypeInformation javaTypeInfo) {
			this.javaTypeInfo = javaTypeInfo;
		}

	}

}
