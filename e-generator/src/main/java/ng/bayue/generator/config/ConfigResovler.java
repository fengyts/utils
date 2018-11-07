package ng.bayue.generator.config;

import ng.bayue.generator.utils.PropertieUtil;

public class ConfigResovler {

	private ConfigModel config;

	public ConfigResovler(String propertieFilePath) {
		try {
			initConfig(propertieFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConfigModel getConfig() {
		return config;
	}

	private void initConfig(String propertieFilePath) throws Exception {
		PropertieUtil util = new PropertieUtil(propertieFilePath);
		config = new ConfigModel();
		config.setAppName(util.getValue("app_name"));
		config.setDbDriverClass(util.getValue("db_driver"));
		config.setDbSchema(util.getValue("db_schema"));
		config.setDbType(util.getValue("db_type"));
		config.setUsername(util.getValue("db_username"));
		config.setPassword(util.getValue("db_password"));
		config.setUrl(util.getValue("db_url"));
		config.setLogicTablePrefix(util.getValue("logic_table_prefix"));
		config.setCreateTimeField(util.getValue("create_time_field"));
		config.setModifiedTimeField(util.getValue("modified_time_field"));
		config.setBasePackageName(util.getValue("package_name"));
		config.setSqlmapOrm(util.getValue("sqlmap_orm"));
		config.setTemplateType(util.getValue("template_type"));
		config.setTables(util.getValue("tables"));
		config.setModelSuffix(util.getValue("model_suffix"));
	}

}
