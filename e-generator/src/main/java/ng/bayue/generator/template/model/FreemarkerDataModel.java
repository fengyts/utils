package ng.bayue.generator.template.model;

public class FreemarkerDataModel {

	private PackageData packageData;

	private TableEntityData tableEngityData;

	private boolean generateUniqueEnable;
	private boolean generateBatchEnable;

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

	public boolean isGenerateUniqueEnable() {
		return generateUniqueEnable;
	}

	public void setGenerateUniqueEnable(boolean generateUniqueEnable) {
		this.generateUniqueEnable = generateUniqueEnable;
	}

	public boolean isGenerateBatchEnable() {
		return generateBatchEnable;
	}

	public void setGenerateBatchEnable(boolean generateBatchEnable) {
		this.generateBatchEnable = generateBatchEnable;
	}

}
