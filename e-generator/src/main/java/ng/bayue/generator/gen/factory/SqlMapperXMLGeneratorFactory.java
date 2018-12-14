package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.SqlMapperXMLGenerator;
import ng.bayue.generator.information.TableInfo;

public class SqlMapperXMLGeneratorFactory implements FactoryGenerator {

	@Override
	public SqlMapperXMLGenerator create(TableInfo tableInfo) {
		return new SqlMapperXMLGenerator(tableInfo);
	}

}
