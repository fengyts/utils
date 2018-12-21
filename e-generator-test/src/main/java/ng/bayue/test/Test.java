package ng.bayue.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Version;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.constants.GeneratorTemplate;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TableEntityData;
import ng.bayue.generator.utils.GeneratorFileUtil;

public class Test {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static void test() {
		FreemarkerDataModel fdm = new FreemarkerDataModel();
		TableEntityData table = new TableEntityData();
		table.setTableName("test_key");
		table.setTableEntityName("TestKey");
		KeyInfoData keyInfo = new KeyInfoData();
		table.setKeyInfo(keyInfo);

		fdm.setTableEngityData(table);

		PackageData packageData = new PackageData();
		String basePackage = "ng.bayue.generator";
		packageData.setBasePackageName(basePackage);
		packageData.setEntityPackageName(basePackage + ".entity");
		packageData.setServicePackageName(basePackage + ".service");

		packageData.setBasePackageSavePath("abc\\bayue\\base");
		fdm.setPackageData(packageData);

		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("rootData", fdm);

		String rootPath = Test.class.getResource("/").getPath();
//		String templatesPath = rootPath + "/template";
		String templatesPath = "";
		// String generateFilePath =
		// "E:\\grepo\\utils\\e-generator\\src\\test\\java\\";
		// generateFilePath += basePackage + "\\service\\TestKey.java";
		// System.out.println(generateFilePath);

		packageData.createPackageDir();
		String generateFilePath = packageData.getServiceSavePath() + "TestKey.java";
		GeneratorFileUtil.generateFile(GeneratorTemplate.MB_SERVICE, generateFilePath, rootMap);
	}
	
	public static void getTemplateFile() throws Exception{
		Version incompatibleImprovements = new Version("2.3.28"); // freemarker 版本
		Configuration config = new Configuration(incompatibleImprovements);
//		config.setDirectoryForTemplateLoading(dir);
		config.setObjectWrapper(new DefaultObjectWrapper(incompatibleImprovements));
		TemplateLoader templateLoader = new ClassTemplateLoader(GeneratorTemplate.class, "/template");
		config.setTemplateLoader(templateLoader);
		Object o =templateLoader.findTemplateSource("mb_service.ftl");
		System.out.println(o);
		File f = new File(o.toString());
		System.out.println(f.exists());
//		Reader reader = templateLoader.getReader(o, "utf-8");
//		char[] charbuf = new char[1024];
//		while(-1 != reader.read(charbuf)){
//			System.out.println(new String(charbuf));
//		}
	}

	public static void main(String[] args) {
		try {
			test();
//			getTemplateFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
