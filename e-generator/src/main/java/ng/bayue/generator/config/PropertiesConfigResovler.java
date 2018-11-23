package ng.bayue.generator.config;

import java.util.Properties;

import ng.bayue.generator.utils.PropertieUtil;

public class PropertiesConfigResovler {

	public static PropertiesConfigModel getConfig(String propertieFilePath) {
		try {
//			PropertieUtil util = new PropertieUtil(propertieFilePath);
//			return initConfig(util);
			return initConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PropertiesConfigModel getConfig(Properties prop) {
		try {
//			PropertieUtil util = new PropertieUtil(prop);
//			return initConfig(util);
			return initConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static PropertiesConfigModel initConfig() throws Exception {
		final PropertiesConfigModel config = new PropertiesConfigModel();
		config.setAppName(PropertieUtil.getValue("app_name"));
		config.setDbDriver(PropertieUtil.getValue("db_driver"));
		config.setDbSchema(PropertieUtil.getValue("db_schema"));
		config.setDbType(PropertieUtil.getValue("db_type"));
		config.setUsername(PropertieUtil.getValue("db_username"));
		config.setPassword(PropertieUtil.getValue("db_password"));
		config.setDbUrl(PropertieUtil.getValue("db_url"));
		config.setLogicTablePrefix(PropertieUtil.getValue("logic_table_prefix"));
		config.setCreateTimeField(PropertieUtil.getValue("create_time_field"));
		config.setModifiedTimeField(PropertieUtil.getValue("modified_time_field"));
		config.setBasePackageName(PropertieUtil.getValue("package_name"));
		config.setSqlmapOrm(PropertieUtil.getValue("sqlmap_orm"));
		config.setTemplateType(PropertieUtil.getValue("template_type"));
		config.setTables(PropertieUtil.getValue("tables"));
		config.setModelSuffix(PropertieUtil.getValue("model_suffix"));

		return config;
	}

//	private static PropertiesConfigModel initConfig(PropertieUtil util) throws Exception {
//		final PropertiesConfigModel config = new PropertiesConfigModel();
//		config.setAppName(util.getValue("app_name"));
//		config.setDbDriver(util.getValue("db_driver"));
//		config.setDbSchema(util.getValue("db_schema"));
//		config.setDbType(util.getValue("db_type"));
//		config.setUsername(util.getValue("db_username"));
//		config.setPassword(util.getValue("db_password"));
//		config.setDbUrl(util.getValue("db_url"));
//		config.setLogicTablePrefix(util.getValue("logic_table_prefix"));
//		config.setCreateTimeField(util.getValue("create_time_field"));
//		config.setModifiedTimeField(util.getValue("modified_time_field"));
//		config.setBasePackageName(util.getValue("package_name"));
//		config.setSqlmapOrm(util.getValue("sqlmap_orm"));
//		config.setTemplateType(util.getValue("template_type"));
//		config.setTables(util.getValue("tables"));
//		config.setModelSuffix(util.getValue("model_suffix"));
//
//		return config;
//	}

}
