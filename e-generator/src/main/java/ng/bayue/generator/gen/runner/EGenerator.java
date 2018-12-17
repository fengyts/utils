package ng.bayue.generator.gen.runner;

import org.mybatis.generator.api.ShellRunner;

import ng.bayue.generator.config.PropertiesConfigLoader;

public class EGenerator {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static void useOriginalGenerator(String configFile) {
		configFile = "eGenerator.xml";
		String[] args = { "-configfile", configFile };
		ShellRunner.main(args);
	}

	public static void generate() {
		initConfig();
	}

	public static void main(String[] args) {

	}

}
