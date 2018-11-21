package ng.bayue.generator.jdbc;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import ng.bayue.generator.config.PropertiesConfigModel;
import ng.bayue.generator.config.PropertiesConfigResovler;

public class JdbcPool implements DataSource {

	private final static LinkedList<Connection> pool = new LinkedList<Connection>();

	private static GenericDataSourceConfig config;

	public JdbcPool(Properties prop) {
		initPool(prop);
	}

//	public JdbcPool(String filePath) {
//		try {
//			File propFile = new File(filePath);
//			Properties prop = new Properties();
//			prop.load(new FileInputStream(propFile));
//			initPool(prop);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	private static void initPool(Properties prop) {
		try {
			final PropertiesConfigModel propModel = PropertiesConfigResovler.getConfig(prop);
			config = new GenericDataSourceConfig(propModel);

			final String driver = config.getDriver();
			final String url = config.getDbUrl();
			final String user = config.getUsername();
			final String password = config.getPassword();
			Class.forName(driver);
			final int poolSize = config.poolSize;
			for (int i = 0; i < poolSize; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		if (pool.size() > 0) {
			final Connection conn = pool.removeFirst();
			InvocationHandler h = new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					String methodName = method.getName();
					if (!"close".equals(methodName)) {
						return method.invoke(conn, args);
					} else {
						// 如果调用的是Connection对象的close方法，就把conn还给数据库连接池
						pool.add(conn);
//						 System.out.println(conn + "被还给pool数据库连接池了！！");
//						 System.out.println("pool数据库连接池大小为" + pool.size());
					}

					return null;
				}
			};
			return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(),
					conn.getClass().getInterfaces(), h);
		} else {
			throw new SQLException("获取数据库连接失败");
		}
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		try {
			Class.forName(config.getDriver());
			Connection conn = DriverManager.getConnection(config.getDbUrl(), username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

}
