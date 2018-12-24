package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.EntityGenerator;
import ng.bayue.generator.information.TableInfo;

public class EntityGeneratorFactory implements FactoryGenerator<EntityGenerator> {

	@Override
	public EntityGenerator create(TableInfo tableInfo) {
		return new EntityGenerator(tableInfo);
	}

}
