package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.ServiceGenerator;
import ng.bayue.generator.information.TableInfo;

public class ServiceGeneratorFactory implements FactoryGenerator<ServiceGenerator> {

	@Override
	public ServiceGenerator create(TableInfo tableInfo) {
		return new ServiceGenerator(tableInfo);
	}

}
