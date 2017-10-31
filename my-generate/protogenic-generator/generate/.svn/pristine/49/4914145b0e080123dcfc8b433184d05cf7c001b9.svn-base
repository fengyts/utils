package com.lhs.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lhs.domain.ReadProperties;

public class ConnectionUtil {

	private ReadProperties properties;

	public ConnectionUtil() {

	}

	public ConnectionUtil(ReadProperties prop) {
		this.properties = prop;
	}

	public Connection getConnection() throws IOException {
		String host = properties.getValue("db_host");
		String port = properties.getValue("db_port");
		String schema = properties.getValue("db_schema");
		String user_name = properties.getValue("db_user_name");
		String pass_word = properties.getValue("db_pass_word");
		String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + schema;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcString, user_name, pass_word);
		} catch (SQLException e) {
			// TODO
		}
		return connection;
	}

	public ReadProperties getProp() {
		return properties;
	}

	public void setProp(ReadProperties prop) {
		this.properties = prop;
	}

}
