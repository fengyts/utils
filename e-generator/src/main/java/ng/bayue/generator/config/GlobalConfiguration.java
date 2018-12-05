package ng.bayue.generator.config;

public class GlobalConfiguration extends AbstractConfiguration {

	protected String[] tableNamePrefixs;

	protected boolean uniqueEnable = DEFAULT_ENABLE;

	protected boolean isAbstractInterface = DEFAULT_ENABLE;

	protected boolean pageQueryEnable = DEFAULT_ENABLE;

	protected boolean batchEnable = DEFAULT_ENABLE;

	protected boolean extendSqlMapEnable = DEFAULT_ENABLE;

	public String[] getTableNamePrefixs() {
		return tableNamePrefixs;
	}

	public void setTableNamePrefixs(String[] tableNamePrefixs) {
		this.tableNamePrefixs = tableNamePrefixs;
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
