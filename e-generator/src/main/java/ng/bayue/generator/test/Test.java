package ng.bayue.generator.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.generator.api.ShellRunner;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.gen.handler.TableInfoHandler;
import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.ConstraintsInfo;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.StringUtils;

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

		// ShellRunner r = new ShellRunner();
		String[] args = { "-configfile", "eGenerator.xml" };
		ShellRunner.main(args);
	}

	public static void testEG() {
		Context context = new Context();
		TableInfoHandler handler = new TableInfoHandler(context);
		// String tableNamePattern = "test_key";
		// String tableNamePattern = "exchange_order_status";
		String tableNamePattern = null;
		long timeStart = System.currentTimeMillis();
		List<TableInfo> tis = handler.introspectTable(tableNamePattern);
		long timeEnd = System.currentTimeMillis();
		System.out.println("耗时：" + (timeEnd - timeStart) + "ms");
		int count = 0;
		for (TableInfo ti : tis) {
			ConstraintsInfo constraintsInfo = ti.getConstraintsInfo();
			if (null == constraintsInfo) {
				count++;
				System.out.println("null:" + ti.getTableName());
			}
			String tableName = ti.getTableName();
			List<Column> columns = ti.getColumns();
			for(Column c : columns){
				if(null == c){
					System.out.println("null column:" + tableName);
				}else {
					if(StringUtils.isBlank(c.getJavaPropertyType())){
						System.out.println("null javaPropertyType:" + tableName + "-column:" + c.getColumnName());
					}
				}
			}
		}
		System.out.println(tis.size());
		System.out.println(count);
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

			// DatabaseMetaData metaData = conn.getMetaData();
			// String catalog = conn.getCatalog();
			// Properties clientInfo = conn.getClientInfo();
			// String schema = conn.getSchema();
			// Map<String, Class<?>> typeMap = conn.getTypeMap();
			//
			// String table = "test_key";

			// 参考博客
			// https://www.cnblogs.com/lbangel/p/3487796.html
			// 获取表索引信息
			// 获取外键
			// 获取主键信息
			// 获取列信息

			System.out.println();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetSql() {
		String dbSchema = "testeg";
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
			final String dbSchema = "testeg";
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


	public static void main(String[] args) {
		initConfig();
		// testJdbcPool();
		// for (int i = 0; i < 5; i++) {
		// testJdbcPool();
		// }
		// testGetSql();
		// testSqlExecute();
		// testGenerator();

		testEG();
		
	}

}
