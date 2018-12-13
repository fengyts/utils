package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public class DaoGeneratorFactory implements FactoryGenerator {

	@Override
	public DaoGenerator create(TableInfo tableInfo) {
		return new DaoGenerator(tableInfo);
	}

}
