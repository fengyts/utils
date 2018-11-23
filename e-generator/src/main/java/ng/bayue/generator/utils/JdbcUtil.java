package ng.bayue.generator.utils;

import java.sql.Connection;
import java.sql.SQLException;

import ng.bayue.generator.jdbc.JdbcPool;

public class JdbcUtil {

	private static final JdbcPool pool = new JdbcPool(PropertiesConfigLoader.getProperties());

	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

}
