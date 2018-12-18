package ng.bayue.generator.mybatis.rules;

/**
 *  property CDATA #IMPLIED
	javaType CDATA #IMPLIED
	column CDATA #IMPLIED
	jdbcType CDATA #IMPLIED
	typeHandler CDATA #IMPLIED
 * @author lenovopc
 *
 */
public class Id extends ChildElement {
	private String property;
	private String javaType;
	private String column;
	private String jdbcType;
	private String typeHandler;

	public Id() {
		super();
	}

	public Id(String property, String javaType, String column, String jdbcType, String typeHandler) {
		this.property = property;
		this.javaType = javaType;
		this.column = column;
		this.jdbcType = jdbcType;
		this.typeHandler = typeHandler;
	}

	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder("<id ");
		append(s, "property", property, false);
		append(s, "javaType", javaType, false);
		append(s, "column", column, false);
		append(s, "jdbcType", jdbcType, false);
		append(s, "typeHandler", typeHandler, false);
		deleteLastWhiteSpace(s);
		closeTag(s, true);
		return s.toString();
	}

	@Override
	public Integer getChildElementsLimitMinTimes() {
		return super.getChildElementsLimitMinTimes();
	}

	@Override
	public void setChildElementsLimitMinTimes(Integer childElementsLimitMinTimes) {
		super.setChildElementsLimitMinTimes(childElementsLimitMinTimes);
	}

	@Override
	public Integer getChildElementsLimitMaxTimes() {
		return super.getChildElementsLimitMaxTimes();
	}

	@Override
	public void setChildElementsLimitMaxTimes(Integer childElementsLimitMaxTimes) {
		super.setChildElementsLimitMaxTimes(childElementsLimitMaxTimes);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getTypeHandler() {
		return typeHandler;
	}

	public void setTypeHandler(String typeHandler) {
		this.typeHandler = typeHandler;
	}

}
