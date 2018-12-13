package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public class ServiceGeneratorFactory implements FactoryGenerator {

	@Override
	public ServiceGenerator create(TableInfo tableInfo) {
		return new ServiceGenerator(tableInfo);
	}

}
