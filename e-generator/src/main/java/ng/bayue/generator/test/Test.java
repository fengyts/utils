package ng.bayue.generator.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.generator.ConstraintsHandler;
import ng.bayue.generator.model.info.TableConstraints;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.PropertiesConfigLoader;

public class Test {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static void testJdbcPool() {
		try {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Connection conn = JdbcUtil.getConnection();
						System.out.println("线程占用一个连接：" + conn);

						Thread.sleep(3000);
						conn.close();
					} catch (SQLException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

			t.start();

			Connection conn = JdbcUtil.getConnection();
			System.out.println(conn);
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetSql() {
		String dbSchema = "checc";
		String tableName = "test_key";
		// String sql = getSqlTableConstrainsSingle(dbSchema, tableName, true);
		// System.out.println(sql);
//		final String sql = DbInformationSchemaSql.getSqlTableConstrains(dbSchema, true, true, tableName,
//				"test_supplier");
//		System.out.println(sql);
		String sql1 = DbInformationSchemaSql.getSqlTableConstraintColumns(dbSchema, false, tableName, "test_supplier");
		System.out.println(sql1);
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
		List<TableConstraints> list = ConstraintsHandler.getConstraints(dbSchema, isAllTables, tableNames);
		System.out.println(list.size());
	}

	public static void main(String[] args) {
		initConfig();
		// for (int i = 0; i < 5; i++) {
		// testJdbcPool();
		// }
		testGetSql();
		// testSqlExecute();
//		testKeyHandler();
	}

}
