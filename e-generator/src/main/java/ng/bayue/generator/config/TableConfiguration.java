package ng.bayue.generator.config;

public class TableConfiguration extends AbstractConfiguration {

	private String tableName;

	private boolean uniqueEnable = DEFAULT_ENABLE;

	private boolean isAbstractInterface = DEFAULT_ENABLE;

	private boolean pageQueryEnable = DEFAULT_ENABLE;

	private boolean batchEnable = DEFAULT_ENABLE;

	private SpecialColumnConfiguration specialColumnConfiguration;

	public SpecialColumnConfiguration getSpecialColumnConfiguration() {
		return specialColumnConfiguration;
	}

	public void setSpecialColumnConfiguration(SpecialColumnConfiguration specialColumnConfiguration) {
		this.specialColumnConfiguration = specialColumnConfiguration;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isUniqueEnable() {
		return uniqueEnable;
	}

	public void setUniqueEnable(boolean uniqueEnable) {
		this.uniqueEnable = uniqueEnable;
	}

	public boolean isAbstractInterface() {
		return isAbstractInterface;
	}

	public void setAbstractInterface(boolean isAbstractInterface) {
		this.isAbstractInterface = isAbstractInterface;
	}

	public boolean isPageQueryEnable() {
		return pageQueryEnable;
	}

	public void setPageQueryEnable(boolean pageQueryEnable) {
		this.pageQueryEnable = pageQueryEnable;
	}

	public boolean isBatchEnable() {
		return batchEnable;
	}

	public void setBatchEnable(boolean batchEnable) {
		this.batchEnable = batchEnable;
	}

}
