package ng.bayue.generator.gen.model;

public class FreemarkerDataModel {

	private PackageData packageData;

	private String entityName;
	private boolean generateUniqueEnable;
	private boolean generateBatchEnable;

	public PackageData getPackageData() {
		return packageData;
	}

	public void setPackageData(PackageData packageData) {
		this.packageData = packageData;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
