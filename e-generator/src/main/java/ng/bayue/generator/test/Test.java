package ng.bayue.generator.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ng.bayue.generator.constants.DbInformationSchemaSql;
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
	
	public static void testSql(){
		try {
			Connection conn = JdbcUtil.getConnection();
			
			final String dbSchema = "checc";
			final String tableName = "test_key";
			final String sql = DbInformationSchemaSql.getSqlTableConstrains(tableName);
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
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
//		for (int i = 0; i < 5; i++) {
//			testJdbcPool();
//		}
		
		testSql();
	}

}
