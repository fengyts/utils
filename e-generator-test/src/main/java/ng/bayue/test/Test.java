package ng.bayue.test;

import java.util.List;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.GlobalConfiguration;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.gen.FreemarkerGenerator;
import ng.bayue.generator.gen.factory.FactoryProducer;
import ng.bayue.generator.gen.factory.FreemarkerGeneratorFactory;
import ng.bayue.generator.gen.handler.TableInfoHandler;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.PackageData;
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
//		String tableNamePattern1 = "checc_user";
		String[] tables  = {"test_generator"};
		long timeStart = System.currentTimeMillis();
		List<TableInfo> tis = handler.introspectTable(tables);

		FreemarkerGeneratorFactory factory = FactoryProducer.getFactory(FreemarkerGeneratorFactory.class);
		for (TableInfo ti : tis) {
			FreemarkerGenerator eg = factory.create(ti);
			FreemarkerDataModel fdm = eg.generate();
		}

		ThreadPoolUtil.shutDown();
		
		System.out.println("generate success!!!");
	}

	public static void main(String[] args) {
		try {
			initConfig();
			testg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
