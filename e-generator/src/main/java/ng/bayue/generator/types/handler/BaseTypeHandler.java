package ng.bayue.generator.types.handler;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import ng.bayue.generator.types.JavaType;

public abstract class BaseTypeHandler implements JdbcTypeResovle {

	protected Map<Integer, JdbcTypeInformation> typeMap;

	public BaseTypeHandler() {
		genericTypeMap();
	}

	private void genericTypeMap() {
		typeMap = new HashMap<Integer, JdbcTypeInformation>();

		typeMap.put(Types.ARRAY, new JdbcTypeInformation("ARRAY", JavaType.OBJECT));
		typeMap.put(Types.BIGINT, new JdbcTypeInformation("BIGINT", JavaType.BasicTypePackaging.LONG));
		typeMap.put(Types.BINARY, new JdbcTypeInformation("BINARY", JavaType.BYTE_ARRAY));
		typeMap.put(Types.BIT, new JdbcTypeInformation("BIT", JavaType.BasicTypePackaging.BOOLEAN));
		typeMap.put(Types.BLOB, new JdbcTypeInformation("BLOB", JavaType.BYTE_ARRAY));
		typeMap.put(Types.BOOLEAN, new JdbcTypeInformation("BOOLEAN", JavaType.BasicTypePackaging.BOOLEAN));
		typeMap.put(Types.CHAR, new JdbcTypeInformation("CHAR", JavaType.STRING));
		typeMap.put(Types.CLOB, new JdbcTypeInformation("CLOB", JavaType.STRING));
		typeMap.put(Types.DATALINK, new JdbcTypeInformation("DATALINK", JavaType.OBJECT));
		typeMap.put(Types.DATE, new JdbcTypeInformation("DATE", JavaType.DATE_UTIL));
		typeMap.put(Types.DECIMAL, new JdbcTypeInformation("DECIMAL", JavaType.BIGDECIMAL));
		typeMap.put(Types.DISTINCT, new JdbcTypeInformation("DISTINCT", JavaType.OBJECT));
		typeMap.put(Types.DOUBLE, new JdbcTypeInformation("DOUBLE", JavaType.BasicTypePackaging.DOUBLE));
		typeMap.put(Types.FLOAT, new JdbcTypeInformation("FLOAT", JavaType.BasicTypePackaging.DOUBLE));
		typeMap.put(Types.INTEGER, new JdbcTypeInformation("INTEGER", JavaType.BasicTypePackaging.INTEGER));
		typeMap.put(Types.JAVA_OBJECT, new JdbcTypeInformation("JAVA_OBJECT", JavaType.OBJECT));
		typeMap.put(Types.LONGNVARCHAR, new JdbcTypeInformation("LONGNVARCHAR", JavaType.STRING));
		typeMap.put(Types.LONGVARBINARY, new JdbcTypeInformation("LONGVARBINARY", JavaType.BYTE_ARRAY));
		typeMap.put(Types.LONGVARCHAR, new JdbcTypeInformation("LONGVARCHAR", JavaType.STRING));
		typeMap.put(Types.NCHAR, new JdbcTypeInformation("NCHAR", JavaType.STRING));
		typeMap.put(Types.NCLOB, new JdbcTypeInformation("NCLOB", JavaType.STRING));
		typeMap.put(Types.NVARCHAR, new JdbcTypeInformation("NVARCHAR", JavaType.STRING));
		typeMap.put(Types.NULL, new JdbcTypeInformation("NULL", JavaType.OBJECT));
		typeMap.put(Types.NUMERIC, new JdbcTypeInformation("NUMERIC", JavaType.BIGDECIMAL));
		typeMap.put(Types.OTHER, new JdbcTypeInformation("OTHER", JavaType.OBJECT));
		typeMap.put(Types.REAL, new JdbcTypeInformation("REAL", JavaType.BasicTypePackaging.FLOAT));
		typeMap.put(Types.REF, new JdbcTypeInformation("REF", JavaType.OBJECT));
		typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT", JavaType.BasicTypePackaging.SHORT));
		typeMap.put(Types.STRUCT, new JdbcTypeInformation("STRUCT", JavaType.OBJECT));
		typeMap.put(Types.TIME, new JdbcTypeInformation("TIME", JavaType.DATE_UTIL));
		typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP", JavaType.DATE_UTIL));
		typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT", JavaType.BasicTypePackaging.BYTE));
		typeMap.put(Types.VARBINARY, new JdbcTypeInformation("VARBINARY", JavaType.BYTE_ARRAY));
		typeMap.put(Types.VARCHAR, new JdbcTypeInformation("VARCHAR", JavaType.STRING));

	}

	public String handler(String jdbcType) {
		
		return null;
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

}
