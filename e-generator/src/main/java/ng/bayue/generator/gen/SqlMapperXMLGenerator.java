package ng.bayue.generator.gen;

import ng.bayue.generator.information.TableInfo;

public class SqlMapperXMLGenerator extends AbstractGenerator implements Generator {

	public SqlMapperXMLGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@Override
	public <M> M generate() {
		return null;
	}

	private String generateAllColumns() {
		return tableInfo.getColumnStr();
	}

	private String generateInsertSql() {
		return "";
	}

	private String generateSelectByPrimaryKeySql() {
		return "";
	}

	private String generateSelectDynamicSql() {
		return "";
	}

	private String generateUpdateByPrimaryKeySql() {
		return "";
	}

	private String generateUpdateDynamicSql() {
		return "";
	}

	private String generateDeletePhysicalSql() {
		return "";
	}

	private String generateBatchSelectByPrimaryKeySql() {
		return null;
	}

	private String generateBatchDeleteByPrimaryKeySql() {
		return null;
	}

	private String generateBatchUpdateSql() {
		return null;
	}

}
