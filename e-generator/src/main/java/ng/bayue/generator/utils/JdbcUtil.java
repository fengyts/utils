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

	public static void closeResultSet(ResultSet rs) {
		if (null != rs)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void closePrepareStatement(PreparedStatement pstat) {
		if (null != pstat)
			try {
				pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void closeConnection(Connection conn) {
		if (null != conn)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(Connection conn, PreparedStatement pstat, ResultSet rs) {
		try {
			closeResultSet(rs);
			closePrepareStatement(pstat);
			closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
