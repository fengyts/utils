package ng.bayue.generator.test;

import java.sql.Connection;
import java.sql.SQLException;

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

	public static void main(String[] args) {
		initConfig();
		for (int i = 0; i < 5; i++) {
			testJdbcPool();
		}
	}

}
