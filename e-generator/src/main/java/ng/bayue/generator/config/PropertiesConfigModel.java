package ng.bayue.generator.config;

import ng.bayue.generator.utils.StringUtils;

public class PropertiesConfigModel {

	private String dbType = "mysql";
	private String dbDriver;
	private String dbSchema;
	private String dbUrl;
	private String username;
	private String password;
	private String sqlmapOrm = "mybatis";
	private String appName;
	private String basePackageName;
	private String templateType = "freemarker";

	private String createTimeField;
	private String modifiedTimeField;

	private String logicTablePrefix;
	private String tables;

	private String modelSuffix;

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		if (StringUtils.isNotBlank(dbType)) {
			this.dbType = dbType;
		}
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
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

	public String getSqlmapOrm() {
		return sqlmapOrm;
	}

	public void setSqlmapOrm(String sqlmapOrm) {
		this.sqlmapOrm = sqlmapOrm;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getCreateTimeField() {
		return createTimeField;
	}

	public void setCreateTimeField(String createTimeField) {
		this.createTimeField = createTimeField;
	}

	public String getModifiedTimeField() {
		return modifiedTimeField;
	}

	public void setModifiedTimeField(String modifiedTimeField) {
		this.modifiedTimeField = modifiedTimeField;
	}

	public String getLogicTablePrefix() {
		return logicTablePrefix;
	}

	public void setLogicTablePrefix(String logicTablePrefix) {
		this.logicTablePrefix = logicTablePrefix;
	}

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public String getModelSuffix() {
		return modelSuffix;
	}

	public void setModelSuffix(String modelSuffix) {
		this.modelSuffix = modelSuffix;
	}

}
