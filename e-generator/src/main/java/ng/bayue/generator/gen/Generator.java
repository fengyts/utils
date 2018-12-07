package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public interface Generator {
	
	<M> M generate(TableInfo tableInfo);

}
