package ng.bayue.generator.jdbc;

import java.util.Properties;

import com.mysql.jdbc.StringUtils;

public class GenericDataSourceConfig {

	private String dbType = "mysql"; // 默认数据库驱动为mysql
	// private String host;
	// private String port;
	// private String dbSchema;
	private String driver;
	private String url;
	private String username;
	private String password;

	public GenericDataSourceConfig() {
	}

	public GenericDataSourceConfig(Properties prop) {
		String dbType = prop.getProperty("db_type");
		if (!StringUtils.isNullOrEmpty(dbType)) {
			this.dbType = dbType;
		}
		// this.host = prop.getProperty("db_host");
		// this.port = prop.getProperty("db_port");
		// this.dbSchema = prop.getProperty("db_schema");
		this.driver = prop.getProperty("db_driver");
		this.url = prop.getProperty("url");
		this.username = prop.getProperty("db_username");
		this.password = prop.getProperty("db_password");
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
