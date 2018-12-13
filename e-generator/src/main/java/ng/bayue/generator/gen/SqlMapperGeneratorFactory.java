package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public class SqlMapperGeneratorFactory implements FactoryGenerator {

	@Override
	public SqlMapperGenerator create(TableInfo tableInfo) {
		return new SqlMapperGenerator(tableInfo);
	}

}
