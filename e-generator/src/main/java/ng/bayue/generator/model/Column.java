package ng.bayue.generator.model;

/**
 * 表列信息
 * @author lenovopc
 *
 */
public class Column {

	/** 列名 */
	private String columnName;
	/** 数据库类型 */
	private String jdbcTypeName;
	/** java属性类型 */
	private String javaPropertyType;
	/** java实例属性-列名驼峰形式 */
	private String javaPropertyName;
	/** 列默认值 */
	private Object defaultValue;
	/** 列注释 */
	private String comment;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getJdbcTypeName() {
		return jdbcTypeName;
	}

	public void setJdbcTypeName(String jdbcTypeName) {
		this.jdbcTypeName = jdbcTypeName;
	}

	public String getJavaPropertyType() {
		return javaPropertyType;
	}

	public void setJavaPropertyType(String javaPropertyType) {
		this.javaPropertyType = javaPropertyType;
	}

	public String getJavaPropertyName() {
		return javaPropertyName;
	}

	public void setJavaPropertyName(String javaPropertyName) {
		this.javaPropertyName = javaPropertyName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

}
