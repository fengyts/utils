package ng.bayue.generator.template.model;

import java.util.List;

public class SqlMapperXMLData {

	private String entityPackageName;
	private String tableEntityClassName;

	private String nameSpace;
	private String baseResultMap;
	/** 所有列名,以逗号分隔 */
	private String baseAllColumns;
	private String whereSql;

	private String insertSql;
	private String selectByPrimaryKeySql;
	private String selectDynamicSql;
	private String updateAllColumnByPrimaryKeySql;
	private String updateDynamicSql;
	private String deletePhysicalSql;

	private List<String> selectByUniqueSqls;
	private List<String> updateDynamicByUniqueSqls;

	private String batchInsertSql;
	private String batchSelectByPrimaryKeySql;
	private String batchUpdateByPrimaryKeySql;
	private String batchDeleteByPrimaryKeySql;

	public String getEntityPackageName() {
		return entityPackageName;
	}

	public void setEntityPackageName(String entityPackageName) {
		this.entityPackageName = entityPackageName;
	}

	public String getTableEntityClassName() {
		return tableEntityClassName;
	}

	public void setTableEntityClassName(String tableEntityClassName) {
		this.tableEntityClassName = tableEntityClassName;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getBaseResultMap() {
		return baseResultMap;
	}

	public void setBaseResultMap(String baseResultMap) {
		this.baseResultMap = baseResultMap;
	}

	public String getBaseAllColumns() {
		return baseAllColumns;
	}

	public void setBaseAllColumns(String baseAllColumns) {
		this.baseAllColumns = baseAllColumns;
	}

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

	public String getInsertSql() {
		return insertSql;
	}

	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}

	public String getSelectByPrimaryKeySql() {
		return selectByPrimaryKeySql;
	}

	public void setSelectByPrimaryKeySql(String selectByPrimaryKeySql) {
		this.selectByPrimaryKeySql = selectByPrimaryKeySql;
	}

	public String getSelectDynamicSql() {
		return selectDynamicSql;
	}

	public void setSelectDynamicSql(String selectDynamicSql) {
		this.selectDynamicSql = selectDynamicSql;
	}

	public String getUpdateAllColumnByPrimaryKeySql() {
		return updateAllColumnByPrimaryKeySql;
	}

	public void setUpdateAllColumnByPrimaryKeySql(String updateAllColumnByPrimaryKeySql) {
		this.updateAllColumnByPrimaryKeySql = updateAllColumnByPrimaryKeySql;
	}

	public String getUpdateDynamicSql() {
		return updateDynamicSql;
	}

	public void setUpdateDynamicSql(String updateDynamicSql) {
		this.updateDynamicSql = updateDynamicSql;
	}

	public String getDeletePhysicalSql() {
		return deletePhysicalSql;
	}

	public void setDeletePhysicalSql(String deletePhysicalSql) {
		this.deletePhysicalSql = deletePhysicalSql;
	}

	public List<String> getSelectByUniqueSqls() {
		return selectByUniqueSqls;
	}

	public void setSelectByUniqueSqls(List<String> selectByUniqueSqls) {
		this.selectByUniqueSqls = selectByUniqueSqls;
	}

	public List<String> getUpdateDynamicByUniqueSqls() {
		return updateDynamicByUniqueSqls;
	}

	public void setUpdateDynamicByUniqueSqls(List<String> updateDynamicByUniqueSqls) {
		this.updateDynamicByUniqueSqls = updateDynamicByUniqueSqls;
	}

	public String getBatchInsertSql() {
		return batchInsertSql;
	}

	public void setBatchInsertSql(String batchInsertSql) {
		this.batchInsertSql = batchInsertSql;
	}

	public String getBatchSelectByPrimaryKeySql() {
		return batchSelectByPrimaryKeySql;
	}

	public void setBatchSelectByPrimaryKeySql(String batchSelectByPrimaryKeySql) {
		this.batchSelectByPrimaryKeySql = batchSelectByPrimaryKeySql;
	}

	public String getBatchUpdateByPrimaryKeySql() {
		return batchUpdateByPrimaryKeySql;
	}

	public void setBatchUpdateByPrimaryKeySql(String batchUpdateByPrimaryKeySql) {
		this.batchUpdateByPrimaryKeySql = batchUpdateByPrimaryKeySql;
	}

	public String getBatchDeleteByPrimaryKeySql() {
		return batchDeleteByPrimaryKeySql;
	}

	public void setBatchDeleteByPrimaryKeySql(String batchDeleteByPrimaryKeySql) {
		this.batchDeleteByPrimaryKeySql = batchDeleteByPrimaryKeySql;
	}

}
