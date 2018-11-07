package ng.bayue.generator.constants;

public enum DbDriverEnum {

	// jdbc:derby:=org.apache.derby.jdbc.EmbeddedDriver
	// jdbc:mysql:=com.mysql.jdbc.Driver
	// jdbc:log4jdbc:=net.sf.log4jdbc.DriverSpy
	// jdbc:oracle:=oracle.jdbc.driver.OracleDriver
	// jdbc:microsoft:=com.microsoft.jdbc.sqlserver.SQLServerDriver
	// jdbc:jtds:=net.sourceforge.jtds.jdbc.Driver
	// jdbc:postgresql:=org.postgresql.Driver
	// jdbc:fake:=com.alibaba.druid.mock.MockDriver
	// jdbc:hsqldb:=org.hsqldb.jdbcDriver
	// jdbc:db2:=COM.ibm.db2.jdbc.app.DB2Driver
	// jdbc:sqlite:=org.sqlite.JDBC
	// jdbc:ingres:=com.ingres.jdbc.IngresDriver
	// jdbc:h2:=org.h2.Driver
	// jdbc:mckoi:=com.mckoi.JDBCDriver


	derby("jdbc:derby:", "org.apache.derby.jdbc.EmbeddedDriver"), 
	mysql("jdbc:mysql://", "com.mysql.jdbc.Driver"), 
	oracle("jdbc:oracle:thin:@", "oracle.jdbc.driver.OracleDriver"), 
	db2("jdbc:oracle://", "com.ibm.db2.jdbc.app.DB2Driver"),
	sqlserver2000("jdbc:microsoft:sqlserver://", "com.microsoft.jdbc.sqlserver.SQLServerDriver"),
	sqlserver2005("jdbc:sqlserver://", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
	sybase("jdbc:sybase:Tds:", "com.sybase.jdbc.SybDriver"),
	informix("jdbc:informix-sqli://", "com.informix.jdbc.IfxDriver"),
	postgresql("jdbc:postgresql://", "org.postgresql.Driver"),
	sqlite("jdbc:sqlite://", "org.sqlite.JDBC"),
	h2("jdbc:h2://", "org.h2.Driver"),
	mckoi("jdbc:mckoi://", "com.mckoi.JDBCDriver")
	;

	public String urlPrefix;
	public String driver;

	private DbDriverEnum(String urlPrefix, String driver) {
		this.urlPrefix = urlPrefix;
		this.driver = driver;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}
