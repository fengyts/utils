package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.FreemarkerGenerator;
import ng.bayue.generator.information.TableInfo;

public class FreemarkerGeneratorFactory implements FactoryGenerator<FreemarkerGenerator> {

	@Override
	public FreemarkerGenerator create(TableInfo tableInfo) {
		return new FreemarkerGenerator(tableInfo);
	}

}
