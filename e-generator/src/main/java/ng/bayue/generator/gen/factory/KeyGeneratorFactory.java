package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.KeyGenerator;
import ng.bayue.generator.information.TableInfo;

public class KeyGeneratorFactory implements FactoryGenerator<KeyGenerator> {

	@Override
	public KeyGenerator create(TableInfo tableInfo) {
		return new KeyGenerator(tableInfo);
	}

}
