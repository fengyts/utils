package ng.bayue.generator.template.model;

import java.io.File;
import java.util.List;

import ng.bayue.generator.utils.StringUtils;

public class PackageData {

	private static final String separator = File.separator;

	/** 工具包名 */
	private List<String> utilsPackageName;
	private String utilsSavePath;

	private String basePackageName;
	private String basePackageSavePath;

	private String commonPackageName;
	private String commonSavePath;

	/** 实体类包名 */
	private String entityPackageName;
	/** 实体类保存路径 */
	private String entitySavePath;
	/** 常量类包名 */
	private String constantPackageName;
	/** 常量类保存路径 */
	private String constantSavePath;

	/** mybatisSqlMap 包名 */
	private String sqlMapPackageName;
	private String sqlMapSavePath;

	/** sql扩展(自定义sql mapping文件) */
	private String sqlMapExtendPackageName;
	private String sqlMapExtendSavePath;

	private String daoPackageName;
	private String daoImplPackageName;
	private String daoSavePath;
	private String daoImplSavePath;

	private String servicePackageName;
	private String serviceImplPackageName;
	private String serviceSavePath;
	private String serviceImplSavePath;

	private String controllerPackageName;
	private String controllerSavePath;

	private String exceptionPackageName;
	private String exceptionSavePath;

	public PackageData() {
		super();
	}

	public void createPackageDir() {
		setDefaultValue();
		createDir(basePackageSavePath);
		createDir(utilsSavePath);
		createDir(commonSavePath);
		createDir(constantSavePath);
		createDir(entitySavePath);
		createDir(sqlMapSavePath);
		createDir(sqlMapExtendSavePath);
		createDir(daoSavePath);
		createDir(daoImplSavePath);
		createDir(serviceSavePath);
		createDir(serviceImplSavePath);
		createDir(controllerSavePath);
		createDir(exceptionSavePath);
	}

	private void createDir(File packageDir) {
		if ((!packageDir.exists()) && !packageDir.isDirectory()) {
			packageDir.mkdirs();
		}
	}

	private void createDir(String filePath) {
		if (StringUtils.isNotBlank(filePath)) {
			if (!filePath.startsWith(basePackageSavePath)) {
				filePath = basePackageSavePath + File.separator + filePath;
			}
			filePath = filePath.replace(".", separator);
			createDir(new File(filePath));
		}
	}

	public boolean checkBlankBasePackageSavePath() {
		return StringUtils.isBlank(basePackageSavePath);
	}

	public boolean checkBlankBasePackageName() {
		return StringUtils.isBlank(basePackageName);
	}

	public void setDefaultValue() {
		String basePackagePath = "";
		// String basePackage = "";
		if (checkBlankBasePackageName()) {
			System.out.println("waring: basePackageSavePath is not assigned, will be use default project");
			basePackagePath = System.getProperty("user.dir") + separator;
		} else {
			if (StringUtils.isNotBlank(basePackageName)) {
				final String[] basePackagePrefix = { "src/main/java", "src.main.java" };
				for (String str : basePackagePrefix) {
					if (basePackageName.startsWith(str)) {
						basePackageName = basePackageName.substring(str.length());
						if (basePackageName.startsWith("/") || basePackageName.startsWith(".")) {
							basePackageName = basePackageName.substring(1);
						}
					}
				}
				basePackageName = basePackageName.replace("/", ".");
				basePackagePath = basePackageName.replace(".", separator) + separator;
			}
		}
		String mavenStructure = "src" + separator + "main" + separator + "java";
		if (!basePackagePath.contains(mavenStructure)) {
			File file = new File(mavenStructure);
			if (file.exists()) {
				basePackagePath = mavenStructure + separator + basePackagePath;
			}
		}
		basePackageSavePath = basePackagePath;
		if (StringUtils.isBlank(utilsSavePath)) {
			utilsSavePath = basePackageSavePath + "util";
		}
		if (StringUtils.isBlank(commonSavePath)) {
			commonSavePath = basePackageSavePath + "common";
		}
		if (StringUtils.isBlank(constantSavePath)) {
			constantSavePath = basePackageSavePath + "constant";
		}
		if (StringUtils.isBlank(entitySavePath)) {
			entitySavePath = basePackageSavePath + "mybatis" + separator + "model";
		}
		if (StringUtils.isBlank(sqlMapSavePath)) {
			sqlMapSavePath = basePackageSavePath + "mybatis" + separator + "sqlmap";
		}
		if (StringUtils.isBlank(sqlMapExtendSavePath)) {
			sqlMapExtendSavePath = basePackageSavePath + "mybatis" + separator + "sqlmap" + separator + "extend";
		}
		if (StringUtils.isBlank(daoSavePath)) {
			daoSavePath = basePackageSavePath + "mybatis" + separator + "dao";
		}
		if (StringUtils.isBlank(daoImplSavePath)) {
			daoImplSavePath = basePackageSavePath + "mybatis" + separator + "dao" + separator + "impl";
		}
		if (StringUtils.isBlank(serviceSavePath)) {
			serviceSavePath = basePackageSavePath + "service";
		}
		if (StringUtils.isBlank(serviceImplSavePath)) {
			serviceImplSavePath = basePackageSavePath + "service" + separator + "impl";
		}
		if (StringUtils.isBlank(controllerSavePath)) {
			controllerSavePath = basePackageSavePath + "controller";
		}
		if (StringUtils.isBlank(exceptionSavePath)) {
			exceptionSavePath = basePackageSavePath + "exception";
		}

	}

	// ========== setter and getter methods ============

	public List<String> getUtilsPackageName() {
		return utilsPackageName;
	}

	public void setUtilsPackageName(List<String> utilsPackageName) {
		this.utilsPackageName = utilsPackageName;
	}

	public String getUtilsSavePath() {
		return utilsSavePath;
	}

	public void setUtilsSavePath(String utilsSavePath) {
		this.utilsSavePath = utilsSavePath;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getBasePackageSavePath() {
		return basePackageSavePath;
	}

	public void setBasePackageSavePath(String basePackageSavePath) {
		this.basePackageSavePath = basePackageSavePath;
	}

	public String getCommonPackageName() {
		return commonPackageName;
	}

	public void setCommonPackageName(String commonPackageName) {
		this.commonPackageName = commonPackageName;
	}

	public String getCommonSavePath() {
		return commonSavePath;
	}

	public void setCommonSavePath(String commonSavePath) {
		this.commonSavePath = commonSavePath;
	}

	public String getEntityPackageName() {
		return entityPackageName;
	}

	public void setEntityPackageName(String entityPackageName) {
		this.entityPackageName = entityPackageName;
	}

	public String getEntitySavePath() {
		return entitySavePath;
	}

	public void setEntitySavePath(String entitySavePath) {
		this.entitySavePath = entitySavePath;
	}

	public String getConstantPackageName() {
		return constantPackageName;
	}

	public void setConstantPackageName(String constantPackageName) {
		this.constantPackageName = constantPackageName;
	}

	public String getConstantSavePath() {
		return constantSavePath;
	}

	public void setConstantSavePath(String constantSavePath) {
		this.constantSavePath = constantSavePath;
	}

	public String getSqlMapPackageName() {
		return sqlMapPackageName;
	}

	public void setSqlMapPackageName(String sqlMapPackageName) {
		this.sqlMapPackageName = sqlMapPackageName;
	}

	public String getSqlMapSavePath() {
		return sqlMapSavePath;
	}

	public void setSqlMapSavePath(String sqlMapSavePath) {
		this.sqlMapSavePath = sqlMapSavePath;
	}

	public String getSqlMapExtendPackageName() {
		return sqlMapExtendPackageName;
	}

	public void setSqlMapExtendPackageName(String sqlMapExtendPackageName) {
		this.sqlMapExtendPackageName = sqlMapExtendPackageName;
	}

	public String getSqlMapExtendSavePath() {
		return sqlMapExtendSavePath;
	}

	public void setSqlMapExtendSavePath(String sqlMapExtendSavePath) {
		this.sqlMapExtendSavePath = sqlMapExtendSavePath;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}

	public String getDaoImplPackageName() {
		return daoImplPackageName;
	}

	public void setDaoImplPackageName(String daoImplPackageName) {
		this.daoImplPackageName = daoImplPackageName;
	}

	public String getDaoSavePath() {
		return daoSavePath;
	}

	public void setDaoSavePath(String daoSavePath) {
		this.daoSavePath = daoSavePath;
	}

	public String getDaoImplSavePath() {
		return daoImplSavePath;
	}

	public void setDaoImplSavePath(String daoImplSavePath) {
		this.daoImplSavePath = daoImplSavePath;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public String getServiceImplPackageName() {
		return serviceImplPackageName;
	}

	public void setServiceImplPackageName(String serviceImplPackageName) {
		this.serviceImplPackageName = serviceImplPackageName;
	}

	public String getServiceSavePath() {
		return serviceSavePath;
	}

	public void setServiceSavePath(String serviceSavePath) {
		this.serviceSavePath = serviceSavePath;
	}

	public String getServiceImplSavePath() {
		return serviceImplSavePath;
	}

	public void setServiceImplSavePath(String serviceImplSavePath) {
		this.serviceImplSavePath = serviceImplSavePath;
	}

	public String getControllerPackageName() {
		return controllerPackageName;
	}

	public void setControllerPackageName(String controllerPackageName) {
		this.controllerPackageName = controllerPackageName;
	}

	public String getControllerSavePath() {
		return controllerSavePath;
	}

	public void setControllerSavePath(String controllerSavePath) {
		this.controllerSavePath = controllerSavePath;
	}

	public String getExceptionPackageName() {
		return exceptionPackageName;
	}

	public void setExceptionPackageName(String exceptionPackageName) {
		this.exceptionPackageName = exceptionPackageName;
	}

	public String getExceptionSavePath() {
		return exceptionSavePath;
	}

	public void setExceptionSavePath(String exceptionSavePath) {
		this.exceptionSavePath = exceptionSavePath;
	}

}
