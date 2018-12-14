package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.Generator;
import ng.bayue.generator.information.TableInfo;

public interface FactoryGenerator {
	
	Generator create(TableInfo tableInfo);

}
