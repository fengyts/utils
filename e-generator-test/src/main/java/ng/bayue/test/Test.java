package ng.bayue.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Version;
import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.GlobalConfiguration;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.constants.GeneratorTemplate;
import ng.bayue.generator.gen.EntityGenerator;
import ng.bayue.generator.gen.FreemarkerGenerator;
import ng.bayue.generator.gen.factory.EntityGeneratorFactory;
import ng.bayue.generator.gen.factory.FactoryGenerator;
import ng.bayue.generator.gen.factory.FactoryProducer;
import ng.bayue.generator.gen.factory.FreemarkerGeneratorFactory;
import ng.bayue.generator.gen.handler.TableInfoHandler;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TableEntityData;
import ng.bayue.generator.utils.GeneratorFileUtil;
import ng.bayue.generator.utils.ThreadPoolUtil;

public class Test {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static Context initContext() {
		Context context = new Context();
		GlobalConfiguration gc = new GlobalConfiguration();

		PackageData pData = new PackageData();
		pData.setBasePackageName("ng.bayue.generator");
		pData.createPackageDir();
		gc.setPackageData(pData);
		context.setGlobalConfiguration(gc);

		return context;
	}



	public static void testg() {
		Context context = initContext();

		TableInfoHandler handler = new TableInfoHandler(context);
		String tableNamePattern = "test_generator";
		long timeStart = System.currentTimeMillis();
		List<TableInfo> tis = handler.introspectTable(tableNamePattern);

		FreemarkerGeneratorFactory factory = FactoryProducer.getFactory(FreemarkerGeneratorFactory.class);
		FreemarkerGenerator eg = factory.create(tis.get(0));
		FreemarkerDataModel fdm = eg.generate();
		
		ThreadPoolUtil.shutDown();
	}

	public static void main(String[] args) {
		try {
			initConfig();
			// test();
			// getTemplateFile();
			testg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
