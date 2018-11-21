package ng.bayue.generator.utils;

import java.sql.Connection;

import ng.bayue.generator.jdbc.GenericJdbcPool;

public class JdbcUtil {

	private GenericJdbcPool pool;

	public Connection getConnection() throws Exception {
		return pool.borrowObject();
	}

}
