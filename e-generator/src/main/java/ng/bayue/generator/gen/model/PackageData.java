package ng.bayue.generator.gen.model;

import java.util.List;

public class PackageData {

	private String basePackageName;

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

	/** 工具包名 */
	private List<String> utilsPackageName;

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
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

	public List<String> getUtilsPackageName() {
		return utilsPackageName;
	}

	public void setUtilsPackageName(List<String> utilsPackageName) {
		this.utilsPackageName = utilsPackageName;
	}

}
