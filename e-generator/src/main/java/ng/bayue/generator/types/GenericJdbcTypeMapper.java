package ng.bayue.generator.types;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import ng.bayue.generator.utils.StringUtils;

public final class GenericJdbcTypeMapper {

	private static final Map<Integer, String> typeToName = new HashMap<Integer, String>();
	private static final Map<String, Integer> nameToType = new HashMap<String, Integer>();

	static {
		// typeToName.put(Types.ARRAY, GenericJdbcType.ARRAY);
		// typeToName.put(Types.BIGINT, GenericJdbcType.BIGINT);
		// typeToName.put(Types.BINARY, GenericJdbcType.BINARY);
		// typeToName.put(Types.BIT, GenericJdbcType.BIT);
		// typeToName.put(Types.BLOB, GenericJdbcType.BLOB);
		// typeToName.put(Types.BOOLEAN, GenericJdbcType.BOOLEAN);
		// typeToName.put(Types.CHAR, GenericJdbcType.CHAR);
		// typeToName.put(Types.CLOB, GenericJdbcType.CLOB);
		// typeToName.put(Types.DATALINK, GenericJdbcType.DATALINK);
		// typeToName.put(Types.DATE, GenericJdbcType.DATE);
		// typeToName.put(Types.DECIMAL, GenericJdbcType.DECIMAL);
		// typeToName.put(Types.DISTINCT, GenericJdbcType.DISTINCT);
		// typeToName.put(Types.DOUBLE, GenericJdbcType.DOUBLE);
		// typeToName.put(Types.FLOAT, GenericJdbcType.FLOAT);
		// typeToName.put(Types.INTEGER, GenericJdbcType.INTEGER);
		// typeToName.put(Types.JAVA_OBJECT, GenericJdbcType.JAVA_OBJECT);
		// typeToName.put(Types.LONGVARBINARY, GenericJdbcType.LONGVARBINARY);
		// typeToName.put(Types.LONGVARCHAR, GenericJdbcType.LONGVARCHAR);
		// typeToName.put(Types.NCHAR, GenericJdbcType.NCHAR);
		// typeToName.put(Types.NCLOB, GenericJdbcType.NCLOB);
		// typeToName.put(Types.NVARCHAR, GenericJdbcType.NVARCHAR);
		// typeToName.put(Types.LONGNVARCHAR, GenericJdbcType.LONGNVARCHAR);
		// typeToName.put(Types.NULL, GenericJdbcType.NULL);
		// typeToName.put(Types.NUMERIC, GenericJdbcType.NUMERIC);
		// typeToName.put(Types.OTHER, GenericJdbcType.OTHER);
		// typeToName.put(Types.REAL, GenericJdbcType.REAL);
		// typeToName.put(Types.REF, GenericJdbcType.REF);
		// typeToName.put(Types.SMALLINT, GenericJdbcType.SMALLINT);
		// typeToName.put(Types.STRUCT, GenericJdbcType.STRUCT);
		// typeToName.put(Types.TIME, GenericJdbcType.TIME);
		// typeToName.put(Types.TIMESTAMP, GenericJdbcType.TIMESTAMP);
		// typeToName.put(Types.TINYINT, GenericJdbcType.TINYINT);
		// typeToName.put(Types.VARBINARY, GenericJdbcType.VARBINARY);
		// typeToName.put(Types.VARCHAR, GenericJdbcType.VARCHAR);
		//
		// nameToType.put(GenericJdbcType.ARRAY, Types.ARRAY);
		// nameToType.put(GenericJdbcType.BIGINT, Types.BIGINT);
		// nameToType.put(GenericJdbcType.BINARY, Types.BINARY);
		// nameToType.put(GenericJdbcType.BIT, Types.BIT);
		// nameToType.put(GenericJdbcType.BLOB, Types.BLOB);
		// nameToType.put(GenericJdbcType.BOOLEAN, Types.BOOLEAN);
		// nameToType.put(GenericJdbcType.CHAR, Types.CHAR);
		// nameToType.put(GenericJdbcType.CLOB, Types.CLOB);
		// nameToType.put(GenericJdbcType.DATALINK, Types.DATALINK);
		// nameToType.put(GenericJdbcType.DATE, Types.DATE);
		// nameToType.put(GenericJdbcType.DECIMAL, Types.DECIMAL);
		// nameToType.put(GenericJdbcType.DISTINCT, Types.DISTINCT);
		// nameToType.put(GenericJdbcType.DOUBLE, Types.DOUBLE);
		// nameToType.put(GenericJdbcType.FLOAT, Types.FLOAT);
		// nameToType.put(GenericJdbcType.INTEGER, Types.INTEGER);
		// nameToType.put(GenericJdbcType.JAVA_OBJECT, Types.JAVA_OBJECT);
		// nameToType.put(GenericJdbcType.LONGVARBINARY, Types.LONGVARBINARY);
		// nameToType.put(GenericJdbcType.LONGVARCHAR, Types.LONGVARCHAR);
		// nameToType.put(GenericJdbcType.NCHAR, Types.NCHAR);
		// nameToType.put(GenericJdbcType.NCLOB, Types.NCLOB);
		// nameToType.put(GenericJdbcType.NVARCHAR, Types.NVARCHAR);
		// nameToType.put(GenericJdbcType.LONGNVARCHAR, Types.LONGNVARCHAR);
		// nameToType.put(GenericJdbcType.NULL, Types.NULL);
		// nameToType.put(GenericJdbcType.NUMERIC, Types.NUMERIC);
		// nameToType.put(GenericJdbcType.OTHER, Types.OTHER);
		// nameToType.put(GenericJdbcType.REAL, Types.REAL);
		// nameToType.put(GenericJdbcType.REF, Types.REF);
		// nameToType.put(GenericJdbcType.SMALLINT, Types.SMALLINT);
		// nameToType.put(GenericJdbcType.STRUCT, Types.STRUCT);
		// nameToType.put(GenericJdbcType.TIME, Types.TIME);
		// nameToType.put(GenericJdbcType.TIMESTAMP, Types.TIMESTAMP);
		// nameToType.put(GenericJdbcType.TINYINT, Types.TINYINT);
		// nameToType.put(GenericJdbcType.VARBINARY, Types.VARBINARY);
		// nameToType.put(GenericJdbcType.VARCHAR, Types.VARCHAR);

		try {
			initMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GenericJdbcTypeMapper() {
	}

	private static void initMapper() throws Exception {
		Class<GenericJdbcType> c = GenericJdbcType.class;
		Field[] jdbcTypes = c.getDeclaredFields();

		Class<Types> typeClass = Types.class;
		Field[] types = typeClass.getDeclaredFields();

		String jdbcType = "", gType = "";
		Integer value;
		for (Field f : jdbcTypes) {
			jdbcType = f.getName();
			jt: for (Field jT : types) {
				gType = jT.getName();
				value = (int) jT.get(null);
				if (jdbcType.equals(gType)) {
					typeToName.put(value, jdbcType);
					nameToType.put(jdbcType, value);
					break jt;
				}
			}
		}

	}

	public static String getJdbcTypeName(int type) {
		String typeName = typeToName.get(type);
		if (StringUtils.isBlank(typeName)) {
			return GenericJdbcType.OTHER;
		}
		return typeName;
	}

	public static int getJdbcType(String jdbcTypeName) {
		Integer type = nameToType.get(jdbcTypeName);
		if (null == type) {
			return Types.OTHER;
		}
		return type;
	}

}
