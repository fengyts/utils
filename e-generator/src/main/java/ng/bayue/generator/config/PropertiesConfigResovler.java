package ng.bayue.generator.config;

import java.util.Properties;

import ng.bayue.generator.utils.PropertieUtil;

public class PropertiesConfigResovler {

	public static PropertiesConfigModel getConfig(String propertieFilePath) {
		try {
			PropertieUtil util = new PropertieUtil(propertieFilePath);
			return initConfig(util);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PropertiesConfigModel getConfig(Properties prop) {
		try {
			PropertieUtil util = new PropertieUtil(prop);
			return initConfig(util);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static PropertiesConfigModel initConfig(PropertieUtil util) throws Exception {
		final PropertiesConfigModel config = new PropertiesConfigModel();
		config.setAppName(util.getValue("app_name"));
		config.setDbDriver(util.getValue("db_driver"));
		config.setDbSchema(util.getValue("db_schema"));
		config.setDbType(util.getValue("db_type"));
		config.setUsername(util.getValue("db_username"));
		config.setPassword(util.getValue("db_password"));
		config.setDbUrl(util.getValue("db_url"));
		config.setLogicTablePrefix(util.getValue("logic_table_prefix"));
		config.setCreateTimeField(util.getValue("create_time_field"));
		config.setModifiedTimeField(util.getValue("modified_time_field"));
		config.setBasePackageName(util.getValue("package_name"));
		config.setSqlmapOrm(util.getValue("sqlmap_orm"));
		config.setTemplateType(util.getValue("template_type"));
		config.setTables(util.getValue("tables"));
		config.setModelSuffix(util.getValue("model_suffix"));

		return config;
	}

}
