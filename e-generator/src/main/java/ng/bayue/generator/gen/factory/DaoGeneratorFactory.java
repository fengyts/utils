package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.DaoGenerator;
import ng.bayue.generator.information.TableInfo;

public class DaoGeneratorFactory implements FactoryGenerator<DaoGenerator> {

	@Override
	public DaoGenerator create(TableInfo tableInfo) {
		return new DaoGenerator(tableInfo);
	}

}
