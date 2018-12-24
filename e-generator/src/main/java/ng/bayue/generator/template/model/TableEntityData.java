package ng.bayue.generator.template.model;

import java.util.List;

import ng.bayue.generator.utils.StringUtils;

public class TableEntityData {

	private KeyInfoData keyInfo;

	private String tablePrefix;
	private String tableName;
	private String tableEntityName;

	private String allColumns;

	private List<String> imports;
	private List<EntityProperty> properties;
	
	public String capitalUpperTableEntityName(){
		return StringUtils.capitalLetterToUpperCase(tableEntityName);
	}

	// =================================
	// getter and setter methods

	public KeyInfoData getKeyInfo() {
		return keyInfo;
	}

	public void setKeyInfo(KeyInfoData keyInfo) {
		this.keyInfo = keyInfo;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableEntityName() {
		return tableEntityName;
	}

	public void setTableEntityName(String tableEntityName) {
		this.tableEntityName = tableEntityName;
	}

	public String getAllColumns() {
		return allColumns;
	}

	public void setAllColumns(String allColumns) {
		this.allColumns = allColumns;
	}

	public List<EntityProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<EntityProperty> properties) {
		this.properties = properties;
	}

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

}
