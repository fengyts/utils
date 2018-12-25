package ng.bayue.generator.template.model;

import ng.bayue.generator.config.ExtendSwitchConfiguration;

public class FreemarkerDataModel {

	private PackageData packageData;

	private TableEntityData tableEngityData;

	private ExtendSwitchConfiguration extendSwitch;

	public String capitalUpperTableEntityName() {
		return tableEngityData.capitalUpperTableEntityName();
	}

	// ===================================
	// methods setter and getter

	public PackageData getPackageData() {
		return packageData;
	}

	public void setPackageData(PackageData packageData) {
		this.packageData = packageData;
	}

	public TableEntityData getTableEngityData() {
		return tableEngityData;
	}

	public void setTableEngityData(TableEntityData tableEngityData) {
		this.tableEngityData = tableEngityData;
	}

	public ExtendSwitchConfiguration getExtendSwitch() {
		return extendSwitch;
	}

	public void setExtendSwitch(ExtendSwitchConfiguration extendSwitch) {
		this.extendSwitch = extendSwitch;
	}

}
