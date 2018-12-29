package ng.bayue.generator.information;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ng.bayue.generator.template.model.EntityProperty;
import ng.bayue.generator.types.JavaTypeInformation;
import ng.bayue.generator.utils.StringUtils;

public class ColumnsInfoExtract {

	private transient ExtractInfo info;
	private List<Column> columns;

	public ColumnsInfoExtract(List<Column> columns) {
		this.columns = columns;
		this.info = init(columns);
	}

	private ExtractInfo init(List<Column> columns) {
		final StringBuilder columnStr = new StringBuilder();
		if (null == columns) {
			throw new NullPointerException();
		}
		Set<String> imports = new TreeSet<String>();
		List<EntityProperty> properties = new ArrayList<EntityProperty>();
		EntityProperty ep = null;
		for (Column c : columns) {
			columnStr.append(c.getColumnName()).append(",");
			JavaTypeInformation javaTypeInfo = c.getJavaTypeInfo();
			if (!javaTypeInfo.isJavaLangPackage()) {
				imports.add(javaTypeInfo.getJavaTypeFully());
			}
			ep = new EntityProperty();
			ep.setPropertyType(javaTypeInfo.getJavaTypeShort());
			ep.setPropertyName(c.getJavaPropertyName());
			ep.setComment(c.getComment());

			properties.add(ep);
		}
		final String res = columnStr.substring(0, columnStr.length() - 1);

		final ExtractInfo info = new ExtractInfo();
		info.setAllColumns(res);
		info.setImports(imports);
		info.setProperties(properties);

		return info;
	}

	public String extractTableColumnsName() {
		return info.getAllColumns();
	}

	public Set<String> extractTableColumnsImports() {
		return info.getImports();
	}

	public List<EntityProperty> extractTableProperties() {
		return info.getProperties();
	}

	/**
	 * 下划线形式字符串转驼峰格式
	 * @param columnName
	 * @return
	 */
	public static String toHumpFormat(String columnName) {
		return StringUtils.toHumpFormat(columnName);
	}

	private static class ExtractInfo {
		private String allColumns;
		// private List<String> imports;
		private Set<String> imports;
		private List<EntityProperty> properties;

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

		public Set<String> getImports() {
			return imports;
		}

		public void setImports(Set<String> imports) {
			this.imports = imports;
		}

	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

}
