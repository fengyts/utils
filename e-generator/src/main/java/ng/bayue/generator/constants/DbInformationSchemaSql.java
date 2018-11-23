package ng.bayue.generator.constants;

import com.mysql.jdbc.StringUtils;

public final class DbInformationSchemaSql {

	static final class TestSqlComment {
		// 查看表结构sql语句：
		// desc test_key;
		// describe test_key;
		// show columns from test_key;
		// show create table test_key;
		// show full fields from test_key;
		// show fields from test_key;
		// show index from test_key;

		// 查看表结构sql语句：
		// select * from information_schema.`COLUMNS` where TABLE_NAME = 'test_key';
		// select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'test_key';
		// select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'test_key';
		// select * from information_schema.STATISTICS where TABLE_NAME = 'test_key';
		// select TABLE_NAME, NON_UNIQUE, INDEX_NAME, SEQ_IN_INDEX, COLUMN_NAME from information_schema.STATISTICS where TABLE_NAME = 'test_key';
		// select * from information_schema.TABLES where TABLE_NAME = 'test_key';
		// select * from information_schema.KEY_COLUMN_USAGE where TABLE_NAME = 'test_key';
	}

	@SuppressWarnings("unused")
	private static final String DB_INFO_SCHEMA_NAME = "information_schema";
	private static final String PLACEHOLDER_DB_SCHEMA = "{0}"; // 数据库名称占位符
	private static final String PLACEHOLDER_DB_TABLE_NAME = "{1}"; // 表名称名占位符

	// "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT,COLUMN_KEY FROM
	// information_schema.columns WHERE table_schema='"+ schema + "' and
	// table_name = '" + tableName + "' ";
	/** 获取表结构的详细信息  */
	private static final String SQL_TABLE_COLUMN_INFO = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY, COLUMN_DEFAULT "
			+ "FROM information_schema.COLUMNS WHERE table_schema='" + PLACEHOLDER_DB_SCHEMA + "' AND table_name = '"
			+ PLACEHOLDER_DB_TABLE_NAME + "'; ";

	/** 获取该数据库的所有表信息  */
	private static final String SQL_DB_SCHEMA_TABLES = "SELECT TABLE_NAME,TABLE_COMMENT "
			+ "FROM information_schema.TABLES WHERE table_schema='" + PLACEHOLDER_DB_SCHEMA + "'; ";

	/** 获取表约束信息  */
	private static final String SQL_TABLE_CONSTRAINTS_INFO = "SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE "
			+ "FROM information_schema.TABLE_CONSTRAINTS WHERE TABLE_NAME = '" + PLACEHOLDER_DB_TABLE_NAME + "'; ";

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
			+ "FROM information_schema.STATISTICS WHERE TABLE_NAME = '" + PLACEHOLDER_DB_TABLE_NAME + "'; ";

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

	/**
	 * 获取表约束信息  Sql语句
	 * @param tableName
	 * @return
	 */
	public static String getSqlTableConstrains(String tableName) {
		if (StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		return SQL_TABLE_CONSTRAINTS_INFO.replace(PLACEHOLDER_DB_TABLE_NAME, tableName);
	}

	/**
	 * 获取表的约束详细信息  Sql语句
	 * @param tableName
	 * @return
	 */
	public static String getSqlTableConstrainStatistics(String tableName) {
		if (StringUtils.isNullOrEmpty(tableName)) {
			return null;
		}
		return SQL_TABLE_CONSTRAINTS_STATISTICS_INFO.replace(PLACEHOLDER_DB_TABLE_NAME, tableName);
	}

}
