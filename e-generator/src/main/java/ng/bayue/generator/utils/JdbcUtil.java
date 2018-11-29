package ng.bayue.generator.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.jdbc.JdbcPool;

public class JdbcUtil {

	private static final JdbcPool pool = new JdbcPool(PropertiesConfigLoader.getProperties());

	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	public static void close(Connection conn, PreparedStatement pstat, ResultSet rs) throws SQLException {
		if (null != rs)
			rs.close();
		if (null != pstat) {
			pstat.close();
		}
		if (null != conn)
			conn.close();
	}

}
