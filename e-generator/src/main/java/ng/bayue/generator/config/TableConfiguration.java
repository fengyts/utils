package ng.bayue.generator.config;

public class TableConfiguration extends GlobalConfiguration {

	private String tableName;

	private String tableNamePrefix;

//	private boolean uniqueEnable;
//	private boolean isAbstractInterface;
//	private boolean pageQueryEnable;
//	private boolean batchEnable;
//	private boolean extendSqlMapEnable;

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

	public String getTableNamePrefix() {
		return tableNamePrefix;
	}

	public void setTableNamePrefix(String tableNamePrefix) {
		this.tableNamePrefix = tableNamePrefix;
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

	public boolean isExtendSqlMapEnable() {
		return extendSqlMapEnable;
	}

	public void setExtendSqlMapEnable(boolean extendSqlMapEnable) {
		this.extendSqlMapEnable = extendSqlMapEnable;
	}

}
