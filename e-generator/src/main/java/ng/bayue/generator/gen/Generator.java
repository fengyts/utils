package ng.bayue.generator.gen;

public interface Generator {

	/**
	 * 
	 * @param tableInfo
	 * @return Model
	 */
	<M> M generate();

}
