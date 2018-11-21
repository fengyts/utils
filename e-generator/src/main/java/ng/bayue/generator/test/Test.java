package ng.bayue.generator.test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

import ng.bayue.generator.jdbc.JdbcPool;

public class Test {
	

	public static void testJdbcPool() {
		try {
			Properties prop = new Properties();
			File file = new File("src/test/metainfo.properties");
			
			Reader reader = new FileReader(file);
			prop.load(reader);
			JdbcPool pool = new JdbcPool(prop);

			Connection conn = pool.getConnection();

			System.out.println(conn);
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		testJdbcPool();
	}

}
