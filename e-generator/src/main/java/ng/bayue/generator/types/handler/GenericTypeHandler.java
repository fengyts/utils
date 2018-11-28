package ng.bayue.generator.types.handler;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import ng.bayue.generator.types.GenericJdbcType;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.JavaType;
import ng.bayue.generator.utils.StringUtils;

public class GenericTypeHandler implements JdbcTypeResovle {

	private static Map<Integer, JdbcTypeInformation> typeMap;

	public GenericTypeHandler() {
		genericTypeMap();
	}
	
//	static {
//		genericTypeMap();
//	}

	private static void genericTypeMap() {
		typeMap = new HashMap<Integer, JdbcTypeInformation>();

		typeMap.put(Types.ARRAY, new JdbcTypeInformation(GenericJdbcType.ARRAY, JavaType.OBJECT));
		typeMap.put(Types.BIGINT, new JdbcTypeInformation(GenericJdbcType.BIGINT, JavaType.BasicTypePackaging.LONG));
		typeMap.put(Types.BINARY, new JdbcTypeInformation(GenericJdbcType.BINARY, JavaType.BYTE_ARRAY));
		typeMap.put(Types.BIT, new JdbcTypeInformation(GenericJdbcType.BIT, JavaType.BasicTypePackaging.BOOLEAN));
		typeMap.put(Types.BLOB, new JdbcTypeInformation(GenericJdbcType.BLOB, JavaType.BYTE_ARRAY));
		typeMap.put(Types.BOOLEAN,
				new JdbcTypeInformation(GenericJdbcType.BOOLEAN, JavaType.BasicTypePackaging.BOOLEAN));
		typeMap.put(Types.CHAR, new JdbcTypeInformation(GenericJdbcType.CHAR, JavaType.STRING));
		typeMap.put(Types.CLOB, new JdbcTypeInformation(GenericJdbcType.CLOB, JavaType.STRING));
		typeMap.put(Types.DATALINK, new JdbcTypeInformation(GenericJdbcType.DATALINK, JavaType.OBJECT));
		typeMap.put(Types.DATE, new JdbcTypeInformation(GenericJdbcType.DATE, JavaType.DATE_UTIL));
		typeMap.put(Types.DECIMAL, new JdbcTypeInformation(GenericJdbcType.DECIMAL, JavaType.BIGDECIMAL));
		typeMap.put(Types.DISTINCT, new JdbcTypeInformation(GenericJdbcType.DISTINCT, JavaType.OBJECT));
		typeMap.put(Types.DOUBLE, new JdbcTypeInformation(GenericJdbcType.DOUBLE, JavaType.BasicTypePackaging.DOUBLE));
		typeMap.put(Types.FLOAT, new JdbcTypeInformation(GenericJdbcType.FLOAT, JavaType.BasicTypePackaging.DOUBLE));
		typeMap.put(Types.INTEGER,
				new JdbcTypeInformation(GenericJdbcType.INTEGER, JavaType.BasicTypePackaging.INTEGER));
		typeMap.put(Types.JAVA_OBJECT, new JdbcTypeInformation(GenericJdbcType.JAVA_OBJECT, JavaType.OBJECT));
		typeMap.put(Types.LONGNVARCHAR, new JdbcTypeInformation(GenericJdbcType.LONGNVARCHAR, JavaType.STRING));
		typeMap.put(Types.LONGVARBINARY, new JdbcTypeInformation(GenericJdbcType.LONGVARBINARY, JavaType.BYTE_ARRAY));
		typeMap.put(Types.LONGVARCHAR, new JdbcTypeInformation(GenericJdbcType.LONGVARCHAR, JavaType.STRING));
		typeMap.put(Types.NCHAR, new JdbcTypeInformation(GenericJdbcType.NCHAR, JavaType.STRING));
		typeMap.put(Types.NCLOB, new JdbcTypeInformation(GenericJdbcType.NCLOB, JavaType.STRING));
		typeMap.put(Types.NVARCHAR, new JdbcTypeInformation(GenericJdbcType.NVARCHAR, JavaType.STRING));
		typeMap.put(Types.NULL, new JdbcTypeInformation(GenericJdbcType.NULL, JavaType.OBJECT));
		typeMap.put(Types.NUMERIC, new JdbcTypeInformation(GenericJdbcType.NUMERIC, JavaType.BIGDECIMAL));
		typeMap.put(Types.OTHER, new JdbcTypeInformation(GenericJdbcType.OTHER, JavaType.OBJECT));
		typeMap.put(Types.REAL, new JdbcTypeInformation(GenericJdbcType.REAL, JavaType.BasicTypePackaging.FLOAT));
		typeMap.put(Types.REF, new JdbcTypeInformation(GenericJdbcType.REF, JavaType.OBJECT));
		typeMap.put(Types.SMALLINT,
				new JdbcTypeInformation(GenericJdbcType.SMALLINT, JavaType.BasicTypePackaging.SHORT));
		typeMap.put(Types.STRUCT, new JdbcTypeInformation(GenericJdbcType.STRUCT, JavaType.OBJECT));
		typeMap.put(Types.TIME, new JdbcTypeInformation(GenericJdbcType.TIME, JavaType.DATE_UTIL));
		typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation(GenericJdbcType.TIMESTAMP, JavaType.DATE_UTIL));
		typeMap.put(Types.TINYINT, new JdbcTypeInformation(GenericJdbcType.TINYINT, JavaType.BasicTypePackaging.BYTE));
		typeMap.put(Types.VARBINARY, new JdbcTypeInformation(GenericJdbcType.VARBINARY, JavaType.BYTE_ARRAY));
		typeMap.put(Types.VARCHAR, new JdbcTypeInformation(GenericJdbcType.VARCHAR, JavaType.STRING));

	}

	@Override
	public String resovle(String jdbcType) {
		if (StringUtils.isBlank(jdbcType)) {
			return JavaType.OBJECT;
		}
		final String jt = jdbcType.toUpperCase();
		final int type = GenericJdbcTypeMapper.getJdbcType(jt);
		final JdbcTypeInformation jdbcTypeInformation = typeMap.get(type);
		return jdbcTypeInformation.getJavaType();
	}

	public static class JdbcTypeInformation {
		private String jdbcType;
		private String javaType;

		public JdbcTypeInformation(String jdbcType, String javaType) {
			this.jdbcType = jdbcType;
			this.javaType = javaType;
		}

		public String getJdbcType() {
			return jdbcType;
		}

		public String getJavaType() {
			return javaType;
		}
	}
	
	public static void main(String[] args) {
		GenericTypeHandler handler = new GenericTypeHandler();
		String str = handler.resovle("int");
		System.out.println(str);
	}

}
