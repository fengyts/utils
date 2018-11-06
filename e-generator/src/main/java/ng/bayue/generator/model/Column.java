package ng.bayue.generator.model;

public class Column {

	/** 列名 */
	private String columnName;
	/** 数据库类型 */
	private String jdbcType;
	/** java实例类型 */
	private String javaType;
	/** java实例属性 */
	private String javaProperty;
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

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaProperty() {
		return javaProperty;
	}

	public void setJavaProperty(String javaProperty) {
		this.javaProperty = javaProperty;
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

}
