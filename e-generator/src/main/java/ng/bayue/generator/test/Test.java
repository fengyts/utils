package ng.bayue.generator.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.mybatis.generator.ant.GeneratorAntTask;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.generator.ConstraintsHandler;
import ng.bayue.generator.model.TableInfo;
import ng.bayue.generator.model.info.TableConstraints;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.handler.GenericTypeHandler;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.PropertiesConfigLoader;

public class Test {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static void testGenerator() {
		// JavaTypeResolver resolver = new JavaTypeResolverDefaultImpl();
		// IntrospectedColumn introspectedColumn = new IntrospectedColumn();
		// introspectedColumn.setActualColumnName("test_pk_supplier");
		// introspectedColumn.setJdbcTypeName("int");
		// introspectedColumn.setJdbcType(4);
		// String jdbcType = resolver.calculateJdbcTypeName(introspectedColumn);
		// FullyQualifiedJavaType javaType =
		// resolver.calculateJavaType(introspectedColumn);
		// System.out.println(jdbcType);
		// System.out.println(javaType.getFullyQualifiedName());

		ShellRunner r = new ShellRunner();
		String[] args = { "-configfile", "eGenerator.xml" };
		r.main(args);

	}
	
	public static void testJdbcPool() {
		try {
			// Thread t = new Thread(new Runnable() {
			// @Override
			// public void run() {
			// try {
			// Connection conn = JdbcUtil.getConnection();
			// System.out.println("线程占用一个连接：" + conn);
			//
			// Thread.sleep(3000);
			// conn.close();
			// } catch (SQLException | InterruptedException e) {
			// e.printStackTrace();
			// }
			// }
			// });
			//
			// t.start();

			Connection conn = JdbcUtil.getConnection();

			DatabaseMetaData metaData = conn.getMetaData();
			String catalog = conn.getCatalog();
			Properties clientInfo = conn.getClientInfo();
			String schema = conn.getSchema();
			Map<String, Class<?>> typeMap = conn.getTypeMap();

			String table = "test_key";
			
			//参考博客
			//https://www.cnblogs.com/lbangel/p/3487796.html
			
			// 获取表索引信息
//			boolean isOnlyUnique = true;
//			ResultSet indexInfos = metaData.getIndexInfo(catalog, schema, table, isOnlyUnique, false);
//			ResultSetMetaData indexMeta = indexInfos.getMetaData();
//			int indexColumnLen = indexMeta.getColumnCount();
//			String columnType = " ——";
//			while (indexInfos.next()) {
//				String columnData = "";
//				for (int i = indexColumnLen; i > 0; i--) {
//					String columnName = indexMeta.getColumnName(i);
//					columnType += columnName + "——";
//					String columnClassName = indexMeta.getColumnClassName(i);
//					if("java.lang.String".equals(columnClassName)){
//						String str = indexInfos.getString(i);
//						str = null == str ? " " : str;
//						columnData += str + "——";
//					} else if("java.lang.Integer".equals(columnClassName)){
//						columnData += String.valueOf(indexInfos.getInt(i)) + "——";
//					} else {
//						String o = String.valueOf(indexInfos.getObject(i));
//						columnData += o + "——";
//					}
//				}
//				System.out.println(columnData);
//			}
//			System.out.println(columnType);
			
			//获取外键
//			ResultSet importedKeys = metaData.getImportedKeys(catalog, schema, table);
//			ResultSetMetaData iKeysMeta = importedKeys.getMetaData();
//			int ikColumnLen = iKeysMeta.getColumnCount();
//			while (importedKeys.next()) {
//				String columnData = "";
//				String columnType = "";
//				for (int i = ikColumnLen; i > 0; i--) {
//					String columnClassName = iKeysMeta.getColumnClassName(i);
//					columnType += iKeysMeta.getColumnName(i) + "——";
//					if("java.lang.String".equals(columnClassName)){
//						String str = importedKeys.getString(i);
//						str = null == str ? " " : str;
//						columnData += str + "——";
//					}
//					if("java.lang.Integer".equals(columnClassName)){
//						columnData += String.valueOf(importedKeys.getInt(i)) + "——";
//					}
//				}
//				System.out.println(columnType);
//				System.out.println(columnData);
//			}
			
			//获取主键信息
//			ResultSet primaryKeys = metaData.getPrimaryKeys(catalog, schema, table);
//			ResultSetMetaData pkMetaData = primaryKeys.getMetaData();
//			int len = pkMetaData.getColumnCount();
//			while (primaryKeys.next()) {
//				String columnData = "";
//				String columnType = "";
//				for (int i = len; i > 0; i--) {
//					String columnClassName = pkMetaData.getColumnClassName(i);
//					columnType += pkMetaData.getColumnName(i) + "——";
//					if("java.lang.String".equals(columnClassName)){
//						String str = primaryKeys.getString(i);
//						str = null == str ? " " : str;
//						columnData += str + "——";
//					}
//					if("java.lang.Integer".equals(columnClassName)){
//						columnData += String.valueOf(primaryKeys.getInt(i)) + "——";
//					}
//				}
//				System.out.println(columnType);
//				System.out.println(columnData);
//			}
			
			// 获取列信息
//			ResultSet rs = metaData.getColumns(catalog, null, table, "%");
//			ResultSetMetaData rsmd = rs.getMetaData();
//			GenericTypeHandler handler = new GenericTypeHandler();
//			while (rs.next()) {
//				int jdbcType = rs.getInt("DATA_TYPE");
//				int columnSize = rs.getInt("COLUMN_SIZE");
//				String columnName = rs.getString("COLUMN_NAME");
//				boolean nullAble = rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
//				int decimalDigits = rs.getInt("DECIMAL_DIGITS");
//				String remarks = rs.getString("REMARKS");
//				String columnDefaultVal = rs.getString("COLUMN_DEF");
//				String isAutoIncrement = rs.getString("IS_AUTOINCREMENT");
//				String isGeneratedColumn = rs.getString("IS_GENERATEDCOLUMN");
//
//				String jdbcTypeName = GenericJdbcTypeMapper.getJdbcTypeName(jdbcType);
//				String javaType = handler.resovle(jdbcTypeName);
//				System.out.println(javaType + "-" + jdbcTypeName + "-" + jdbcType + "-" + columnSize + "-" + columnName
//						+ "-" + nullAble + "-" + decimalDigits + "-" + remarks + "-" + columnDefaultVal + "-"
//						+ isAutoIncrement + "-" + "-" + isGeneratedColumn);
//			}

			System.out.println();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetSql() {
		String dbSchema = "checc";
		String tableName = "test_key";
		String[] tableNames = { "test_key", "test_supplier" };
		// String sql = getSqlTableConstrainsSingle(dbSchema, tableName, true);
		// System.out.println(sql);
		// final String sql =
		// DbInformationSchemaSql.getSqlTableConstrains(dbSchema, true, true,
		// tableName,
		// "test_supplier");
		// System.out.println(sql);
		// String sql1 =
		// DbInformationSchemaSql.getSqlTableConstraintColumns(dbSchema, false,
		// tableName, "test_supplier");
		// System.out.println(sql1);
		String sql2 = DbInformationSchemaSql.getSqlTableColumnDetailInfo(dbSchema, false, tableNames);
		System.out.println(sql2);
	}

	public static void testSqlExecute() {
		try {
			Connection conn = JdbcUtil.getConnection();
			final String dbSchema = "checc";
			final String tableName = "test_key";
			final String sql = DbInformationSchemaSql.getSqlTableConstrains(dbSchema, true, true, tableName,
					"test_supplier");
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String str = rs.getString(1);
				String str1 = rs.getString(2);
				String str2 = rs.getString(3);
				System.out.println(str + "-" + str1 + "-" + str2);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void testKeyHandler() {
		final String dbSchema = "checc";
		final String[] tableNames = new String[] { "test_key", "test_supplier" };
		final boolean isAllTables = false;
		// List<TableConstraints> list =
		// ConstraintsHandler.getConstraints(dbSchema, isAllTables, tableNames);
		// System.out.println(list.size());
		List<TableInfo> infos = ConstraintsHandler.getTableDetailInfo(dbSchema, isAllTables, tableNames);
		System.out.println(infos.size());
	}

	public static void main(String[] args) {
		initConfig();
		testJdbcPool();
		// for (int i = 0; i < 5; i++) {
		// testJdbcPool();
		// }
		// testGetSql();
		// testSqlExecute();
		// testKeyHandler();
		// testGenerator();

	}

}
