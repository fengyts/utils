package ng.bayue.generator.constants;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

public final class DbInformationSchemaSql {

	// 查看表结构sql语句：
	// desc test_key;
	// describe test_key;
	// show columns from test_key;
	// show create table test_key;
	// show full fields from test_key;
	// show fields from test_key;
	// show index from test_key;

	// 查看表结构sql语句：
	// select * from information_schema.`COLUMNS` where TABLE_NAME =
	// 'test_key';
	// select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME =
	// 'test_key';
	// select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from
	// information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'test_key';
	// select * from information_schema.STATISTICS where TABLE_NAME =
	// 'test_key';
	// select TABLE_NAME, NON_UNIQUE, INDEX_NAME, SEQ_IN_INDEX, COLUMN_NAME
	// from information_schema.STATISTICS where TABLE_NAME = 'test_key';
	// select * from information_schema.TABLES where TABLE_NAME =
	// 'test_key';
	// select * from information_schema.KEY_COLUMN_USAGE where TABLE_NAME =
	// 'test_key';

	// 获取表约束join sql:
	// SELECT
	// tc.TABLE_NAME, tc.CONSTRAINT_NAME, tc.CONSTRAINT_TYPE,
	// s.INDEX_NAME, s.NON_UNIQUE, s.SEQ_IN_INDEX, s.COLUMN_NAME
	// FROM information_schema.TABLE_CONSTRAINTS tc
	// LEFT JOIN information_schema.STATISTICS s ON s.TABLE_NAME =
	// tc.TABLE_NAME
	// WHERE tc.TABLE_SCHEMA = 'checc' AND tc.CONSTRAINT_TYPE IN ('PRIMARY
	// KEY', 'UNIQUE') AND tc.TABLE_NAME IN ('test_key', 'test_supplier')
	// AND s.TABLE_NAME IN ('test_key', 'test_supplier') AND
	// tc.CONSTRAINT_NAME = s.INDEX_NAME
	// ORDER BY tc.TABLE_NAME, tc.CONSTRAINT_TYPE, s.INDEX_NAME DESC,
	// s.SEQ_IN_INDEX;

	@SuppressWarnings("unused")
	private static final String DB_INFO_SCHEMA_NAME = "information_schema";
	/** 数据库名称占位符 */
	private static final String PLACEHOLDER_DB_SCHEMA = "{0}";
	/** 表名称名占位符 */
	private static final String PLACEHOLDER_DB_TABLE_NAME = "{1}";
	/** 只查询唯一索引key(含主键)约束占位符 */
	private static final String PLACEHOLDER_UK_ONLY = "{3}";
	private static final String PLACEHOLDER_UK_WHERE = " AND CONSTRAINT_TYPE IN ('PRIMARY KEY', 'UNIQUE') ";
	/** 是否所有表 */
	private static final String PLACEHOLDER_IS_ALL_TABLE = "{4}";
	private static final String PLACEHOLDER_IS_ALL_WHERE = " AND TABLE_NAME IN (" + PLACEHOLDER_DB_TABLE_NAME + ") ";
	private static final String PLACEHOLDER_IS_ALL_WHERE1 = " AND tc.TABLE_NAME IN (" + PLACEHOLDER_DB_TABLE_NAME
			+ ") AND s.TABLE_NAME IN (" + PLACEHOLDER_DB_TABLE_NAME + ") ";

	// "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT,COLUMN_KEY FROM
	// information_schema.columns WHERE table_schema='"+ schema + "' and
	// table_name = '" + tableName + "' ";
	/** 获取表结构的详细信息  */
	private static final String SQL_TABLE_COLUMN_INFO = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY, COLUMN_DEFAULT "
			+ "FROM information_schema.COLUMNS WHERE TABLE_SCHEMA ='" + PLACEHOLDER_DB_SCHEMA + "' AND TABLE_NAME = '"
			+ PLACEHOLDER_DB_TABLE_NAME + "'; ";

	/** 
	 * 获取表结构的详细信息, 包含表字段详细约束信息等<br>
	 * 占位符{4}表示的字符串为: <br>
	 * "AND c.TABLE_NAME IN ('test_key','test_supplier')" <br>或者 "AND c.TABLE_NAME = 'test_key'
	 */
	private static final String SQL_TABLE_COLUMN_DETAIL_INFO = "SELECT " + SqlTableColumnDetailSelectMapper.getSelects()
			+ " FROM information_schema.COLUMNS c "
			+ "LEFT JOIN information_schema.STATISTICS s ON s.COLUMN_NAME = c.COLUMN_NAME AND s.TABLE_NAME = c.TABLE_NAME "
			+ "LEFT JOIN information_schema.TABLE_CONSTRAINTS tc ON tc.TABLE_NAME = s.TABLE_NAME AND tc.CONSTRAINT_NAME = s.INDEX_NAME "
			+ "WHERE c.TABLE_SCHEMA = '" + PLACEHOLDER_DB_SCHEMA + "' " + PLACEHOLDER_IS_ALL_TABLE
			+ " ORDER BY c.TABLE_NAME; ";

	/** 获取该数据库的所有表信息  */
	private static final String SQL_DB_SCHEMA_TABLES = "SELECT TABLE_NAME,TABLE_COMMENT "
			+ "FROM information_schema.TABLES WHERE TABLE_SCHEMA ='" + PLACEHOLDER_DB_SCHEMA + "'; ";

	/** 获取表约束信息sql通用*/
	private static final String SQL_TABLE_CONSTRAINTS_PREFIX = "SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE "
			+ "FROM information_schema.TABLE_CONSTRAINTS WHERE TABLE_SCHEMA = '" + PLACEHOLDER_DB_SCHEMA + "' ";
	/** 获取表约束信息-单表  */
	private static final String SQL_TABLE_CONSTRAINTS_INFO_SINGLE = SQL_TABLE_CONSTRAINTS_PREFIX + PLACEHOLDER_UK_ONLY
			+ "AND TABLE_NAME = '" + PLACEHOLDER_DB_TABLE_NAME + "'; ";
	/** 获取表约束信息-该数据库所有表或指定部分表   */
	private static final String SQL_TABLE_CONSTRAINTS_INFO_ALL = SQL_TABLE_CONSTRAINTS_PREFIX + PLACEHOLDER_UK_ONLY
			+ PLACEHOLDER_IS_ALL_TABLE + " ORDER BY TABLE_NAME, CONSTRAINT_TYPE; ";

	/** 
	 * 获取表的约束详细信息: 根据SQL_TABLE_CONSTRAINTS_INFO查询的结果再次获取, 只获取 NON_UNIQUE = 0, 即主键和唯一索引的约束项
	 *
	 * 执行sql:show index;或者执行SQL_TABLE_CONSTRAINTS_INFO(select * from information_schema.STATISTICS...)会返回以下字段
	 * 1、Table 表的名称。
	 * 2、 Non_unique 如果索引不能包括重复词, 则为0, 如果可以则为1。
	 * 3、 Key_name 索引的名称
	 * 4、 Seq_in_index 索引中的列序列号，从1开始。
	 * 5、 Column_name 列名称。
	 * 6、 Collation 列以什么方式存储在索引中。在MySQL中，有值‘A’（升序）或NULL（无分类）。
	 * 7、Cardinality 索引中唯一值的数目的估计值。通过运行ANALYZE TABLE或myisamchk -a可以更新。
	 *   基数根据被存储为整数的统计数据来计数，所以即使对于小型表，该值也没有必要是精确的。基数越大，当进行联合时，MySQL使用该索引的机会就越大。
	 * 8、Sub_part 如果列只是被部分地编入索引，则为被编入索引的字符的数目。如果整列被编入索引，则为NULL。
	 * 9、 Packed 指示关键字如何被压缩。如果没有被压缩，则为NULL。
	 * 10、 Null 如果列含有NULL，则含有YES。如果没有，则该列含有NO。
	 * 11、 Index_type 用过的索引方法（BTREE, FULLTEXT, HASH, RTREE）。
	 */
	private static final String SQL_TABLE_CONSTRAINTS_STATISTICS_INFO = "SELECT TABLE_NAME, NON_UNIQUE, INDEX_NAME, SEQ_IN_INDEX, COLUMN_NAME "
			+ "FROM information_schema.STATISTICS WHERE TABLE_SCHEMA ='" + PLACEHOLDER_DB_SCHEMA
			+ "' AND TABLE_NAME = '" + PLACEHOLDER_DB_TABLE_NAME + "'; ";

	/** 本sql语句最终结果等效于SQL_TABLE_CONSTRAINTS_STATISTICS_INFO,
	 * 而SQL_TABLE_CONSTRAINTS_STATISTICS_INFO必须以SQL_TABLE_CONSTRAINTS_?一系列sql语句执行的结果来入参，
	 * 因而本sql更简洁有效(join 查询)
	 */
	private static final String SQL_TABLE_CONSTRAINTS_KEY_INFO = "SELECT tc.TABLE_NAME, tc.CONSTRAINT_NAME, tc.CONSTRAINT_TYPE, "
			+ "s.INDEX_NAME, s.NON_UNIQUE, s.SEQ_IN_INDEX, s.COLUMN_NAME "
			+ "FROM information_schema.TABLE_CONSTRAINTS tc "
			+ "LEFT JOIN information_schema.STATISTICS s ON s.TABLE_NAME = tc.TABLE_NAME WHERE tc.TABLE_SCHEMA = '"
			+ PLACEHOLDER_DB_SCHEMA + "' AND s.TABLE_SCHEMA = '" + PLACEHOLDER_DB_SCHEMA
			+ "' AND tc.CONSTRAINT_NAME = s.INDEX_NAME " + "AND tc.CONSTRAINT_TYPE IN ('PRIMARY KEY', 'UNIQUE') "
			+ PLACEHOLDER_IS_ALL_TABLE
			+ "ORDER BY tc.TABLE_NAME, tc.CONSTRAINT_TYPE, s.INDEX_NAME DESC, s.SEQ_IN_INDEX; ";

	/**
	 * 获取表结构的详细信息 Sql语句
	 * @param dbSchema
	 * @param tableName
	 * @return
	 */
	public static String getSqlColumnInfo(String dbSchema, String tableName) {
		if (StringUtils.isNullOrEmpty(dbSchema) || StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		return SQL_TABLE_COLUMN_INFO.replace(PLACEHOLDER_DB_SCHEMA, dbSchema).replace(PLACEHOLDER_DB_TABLE_NAME,
				tableName);
	}

	/**
	 * 获取该数据库的所有表信息 Sql语句
	 * @param dbSchema
	 * @return
	 */
	public static String getSqlSchemaTables(String dbSchema) {
		if (StringUtils.isNullOrEmpty(dbSchema)) {
			return null;
		}
		return SQL_DB_SCHEMA_TABLES.replace(PLACEHOLDER_DB_SCHEMA, dbSchema);
	}

	public static String getSqlTableConstrains(String dbSchema, boolean isOnlyUK, boolean isAllTables,
			String... tableNames) {
		if (StringUtils.isNullOrEmpty(dbSchema)) {
			return null;
		}
		String sql = "";

		// boolean isAllTables = true; // 表信息为空，则默认获取所有
		isAllTables = true; // 表信息为空，则默认获取所有, 该字段为预留字段
		int length = 0;
		if (null != tableNames && (length = tableNames.length) != 0) {
			isAllTables = false;
			if (length == 1) { // 单表
				sql = getSqlTableConstrainsSingle(dbSchema, tableNames[0], isOnlyUK);
				return sql;
			}
		}

		sql = getSqlTableConstrainsAll(dbSchema, isOnlyUK, isAllTables, tableNames);

		return sql;
	}

	/**
	 * 获取单表约束信息  Sql语句
	 * @param tableName
	 * @return
	 */
	private static String getSqlTableConstrainsSingle(String dbSchema, String tableName, boolean isOnlyUK) {
		if (StringUtils.isNullOrEmpty(dbSchema) || StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		String sql = SQL_TABLE_CONSTRAINTS_INFO_SINGLE.replace(PLACEHOLDER_DB_SCHEMA, dbSchema)
				.replace(PLACEHOLDER_DB_TABLE_NAME, tableName);
		sql = handleOnlyUKConstrains(isOnlyUK, sql);
		return sql;
	}

	/**
	 * 获取表约束信息  Sql语句
	 * 
	 * @param dbSchema 数据库名称
	 * @param isOnlyUk 是否只获取唯一约束key
	 * @param isAllTables 是否该数据库所有表, 若tableNames不为空则isAllTables=false
	 * @param tableNames 指定该数据库部分表
	 * @return
	 */
	private static String getSqlTableConstrainsAll(String dbSchema, boolean isOnlyUK, boolean isAllTables,
			String... tableNames) {
		if (StringUtils.isNullOrEmpty(dbSchema)) {
			return null;
		}
		String sql = SQL_TABLE_CONSTRAINTS_INFO_ALL.replace(PLACEHOLDER_DB_SCHEMA, dbSchema);
		sql = handleOnlyUKConstrains(isOnlyUK, sql);
//		isAllTables = isAllTables(isAllTables, tableNames);
		if (isAllTables) {
			sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE, "");
		} else {
			String tables = "'";
			for (String t : tableNames) {
				tables = tables + t + "', '";
			}
			tables = tables.substring(0, tables.length() - 3);
			sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE,
					PLACEHOLDER_IS_ALL_WHERE.replace(PLACEHOLDER_DB_TABLE_NAME, tables));
		}
		return sql;
	}

	private static String handleOnlyUKConstrains(boolean isOnlyUK, String sql) {
		String res = "";
		if (isOnlyUK) {
			res = sql.replace(PLACEHOLDER_UK_ONLY, PLACEHOLDER_UK_WHERE);
		} else {
			res = sql.replace(PLACEHOLDER_UK_ONLY, "");
		}
		return res;
	}

	/**
	 * 获取表的约束详细信息  Sql语句
	 * @param tableName
	 * @return
	 */
	public static String getSqlTableConstrainStatistics(String dbSchema, String tableName) {
		if (StringUtils.isNullOrEmpty(dbSchema) || StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		return SQL_TABLE_CONSTRAINTS_STATISTICS_INFO.replace(PLACEHOLDER_DB_TABLE_NAME, tableName);
	}

	/**
	 * 获取表列约束信息
	 * @param dbSchema
	 * @param isAllTables
	 * @param tableNames
	 * @return
	 */
	public static String getSqlTableConstraintColumns(String dbSchema, boolean isAllTables, String... tableNames) {
		if (StringUtils.isNullOrEmpty(dbSchema)) {
			return null;
		}
		String sql = SQL_TABLE_CONSTRAINTS_KEY_INFO;
		// 表信息为空，则默认获取所有, 该字段为预留字段
//		isAllTables = isAllTables(isAllTables, tableNames);
		sql = sql.replace(PLACEHOLDER_DB_SCHEMA, dbSchema);
		if (isAllTables) {
			sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE, "");
		} else {
			String tables = "'";
			for (String t : tableNames) {
				tables = tables + t + "', '";
			}
			tables = tables.substring(0, tables.length() - 3);
			sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE,
					PLACEHOLDER_IS_ALL_WHERE1.replace(PLACEHOLDER_DB_TABLE_NAME, tables));
		}
		return sql;
	}

	/**
	 * 获取表结构、列、约束等详细信息
	 * @param dbSchema
	 * @param isAllTables
	 * @param tableNames
	 * @return
	 */
	public static String getSqlTableColumnDetailInfo(String dbSchema, boolean isAllTables, String... tableNames) {
		if (StringUtils.isNullOrEmpty(dbSchema)) {
			return null;
		}
		String sql = SQL_TABLE_COLUMN_DETAIL_INFO;
		// 表信息为空，则默认获取所有, 该字段为预留字段
//		isAllTables = isAllTables(isAllTables, tableNames);
		sql = sql.replace(PLACEHOLDER_DB_SCHEMA, dbSchema);
		if (isAllTables) {
			sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE, "");
		} else {
			if (tableNames.length == 1) {
				final String replaceStr = "AND c.TABLE_NAME = '" + tableNames[0] + "'";
				sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE, replaceStr);
			} else {
				String tables = "'";
				for (String t : tableNames) {
					tables = tables + t + "', '";
				}
				tables = tables.substring(0, tables.length() - 3);
				final String replaceStr = "AND c.TABLE_NAME IN (" + tables + ")";
				sql = sql.replace(PLACEHOLDER_IS_ALL_TABLE, replaceStr);
			}
		}
		return sql;
	}

	/**
	 * 封装<link>DbInformationSchemaSql.SQL_TABLE_COLUMN_DETAIL_INFO</link> sql 查询的列以及列的index位置信息, 方便在ResultSet中按照列名获取index: rs.getString(index);
	 * 若要增加或删除列的查询只需要修改枚举类：SC, SS, STC的枚举项以及结果集处理的类<link>ConstraintsHandler</link>
	 * 
	 * @author lenovopc
	 *
	 */
	public static class SqlTableColumnDetailSelectMapper {
		public static interface EGeneric {
			// Enum<?>[] items();
			// String getPrefix();
			// int getIndex(Enum<?> e);
		}

		/** FROM information_schema.COLUMNS c 的字段 */
		public static enum SC implements EGeneric {
			TABLE_NAME, COLUMN_NAME, DATA_TYPE, COLUMN_KEY, COLUMN_DEFAULT, COLUMN_COMMENT;

			public static final String TABLE_ALIAS_PREFIX = "c";
			public static final int LENGTH = SC.values().length;
		}

		/** LEFT JOIN information_schema.STATISTICS s 的字段 */
		public static enum SS implements EGeneric {
			INDEX_NAME, NON_UNIQUE, SEQ_IN_INDEX;

			public static final String TABLE_ALIAS_PREFIX = "s";
			public static final int LENGTH = SS.values().length;
		}

		/** LEFT JOIN information_schema.TABLE_CONSTRAINTS tc 的字段 */
		public static enum STC implements EGeneric {
			CONSTRAINT_NAME, CONSTRAINT_TYPE;

			public static final String TABLE_ALIAS_PREFIX = "tc";
			public static final int LENGTH = STC.values().length;
		}

		private static final Map<String, Integer> COLUMN_INDEX_MAPPER = new LinkedHashMap<String, Integer>();

		private static final String[] SELECTS_ALL = new String[SC.LENGTH + SS.LENGTH + STC.LENGTH];

		static {
			initColumns();
		}

		private static int index = 0;

		private static void initColumns() {
			try {
				SC[] sc = SC.values();
				fill(sc, SC.LENGTH, SC.TABLE_ALIAS_PREFIX);
				SS[] ss = SS.values();
				fill(ss, SS.LENGTH, SS.TABLE_ALIAS_PREFIX);
				STC[] stc = STC.values();
				fill(stc, STC.LENGTH, STC.TABLE_ALIAS_PREFIX);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void fill(Enum<?>[] e, int len, String prefix) throws Exception {
			String name;
			for (int i = 0; i < len; i++) {
				name = prefix + e[i].name();
				if (COLUMN_INDEX_MAPPER.containsKey(name)) {
					Arrays.fill(SELECTS_ALL, null);
					COLUMN_INDEX_MAPPER.clear();
					throw new Exception("获取表列约束信息的sql查询列存在重复列");
				}
				COLUMN_INDEX_MAPPER.put(name, index);
				SELECTS_ALL[index] = prefix + "." + e[i];
				index++;
			}
		}

		public static String getSelects() {
			String[] s = SqlTableColumnDetailSelectMapper.SELECTS_ALL;
			String selects = Arrays.toString(s);
			if (selects.startsWith("[")) {
				selects = selects.substring(1);
			}
			if (selects.endsWith("]")) {
				selects = selects.substring(0, selects.length() - 1);
			}
			return selects;
		}

		public static int getIndex(Enum<?> e) {
			String key = "";
			if (e instanceof SC) {
				key = SC.TABLE_ALIAS_PREFIX + e.name();
			} else if (e instanceof SS) {
				key = SS.TABLE_ALIAS_PREFIX + e.name();
			} else {
				key = STC.TABLE_ALIAS_PREFIX + e.name();
			}
			Integer index = COLUMN_INDEX_MAPPER.get(key);
			return null == index ? 0 : index + 1;
		}

		public static int getIndexEGeneric(EGeneric e) {
			String key = "";
			if (e instanceof SC) {
				SC sc = (SC) e;
				key = SC.TABLE_ALIAS_PREFIX + sc.name();
			} else if (e instanceof SS) {
				SS ss = (SS) e;
				key = SS.TABLE_ALIAS_PREFIX + ss.name();
			} else {
				STC stc = (STC) e;
				key = STC.TABLE_ALIAS_PREFIX + stc.name();
			}
			Integer index = COLUMN_INDEX_MAPPER.get(key);
			return null == index ? 0 : index + 1;
		}

//		public static void main(String[] args) {
//			System.out.println(SqlTableColumnDetailSelectMapper.getSelects());
//			System.out.println(COLUMN_INDEX_MAPPER);
//			int index = getIndexEGeneric(SC.COLUMN_COMMENT);
//			System.out.println(index);
//		}

	}

}
