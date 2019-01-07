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


}
