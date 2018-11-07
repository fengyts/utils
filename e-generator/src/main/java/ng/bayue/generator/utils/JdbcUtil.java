package ng.bayue.generator.utils;

import java.sql.Connection;

import ng.bayue.generator.jdbc.JdbcPool;

public class JdbcUtil {

	private JdbcPool pool;

	public Connection getConnection() throws Exception {
		return pool.borrowObject();
	}

}
