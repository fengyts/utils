package ng.bayue.generator.config;

import ng.bayue.generator.template.model.PackageData;

public class GlobalConfiguration extends ExtendSwitchConfiguration {

	protected String[] tableNamePrefixs;

	protected PackageData packageData;

	public String[] getTableNamePrefixs() {
		return tableNamePrefixs;
	}

	public void setTableNamePrefixs(String[] tableNamePrefixs) {
		this.tableNamePrefixs = tableNamePrefixs;
	}

	public PackageData getPackageData() {
		return packageData;
	}

	public void setPackageData(PackageData packageData) {
		this.packageData = packageData;
	}

}
