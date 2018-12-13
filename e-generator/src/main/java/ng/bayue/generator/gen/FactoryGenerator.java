package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public interface FactoryGenerator {
	
	Generator create(TableInfo tableInfo);

}
