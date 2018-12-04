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
	private String jdbcType;
	/** java实例类型 */
	private String javaPropertyType;
	/** java实例属性-列名驼峰形式 */
	private String javaPropertyName;
	/** 类型处理器 */
	private String typeHandler;
	/** 列注释 */
	private String comment;

	/** 列默认值 */
	private Object defaultValue;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
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

	public String getTypeHandler() {
		return typeHandler;
	}

	public void setTypeHandler(String typeHandler) {
		this.typeHandler = typeHandler;
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
