package ng.bayue.generator.mybatis.rules;

import ng.bayue.generator.constants.SymbolConstant;

/**
 * 
	<!ELEMENT idArg EMPTY>
	<!ATTLIST idArg
	javaType CDATA #IMPLIED
	column CDATA #IMPLIED
	jdbcType CDATA #IMPLIED
	typeHandler CDATA #IMPLIED
	select CDATA #IMPLIED
	resultMap CDATA #IMPLIED
	>
 * 
 * @author lenovopc
 *
 */

public class IdArg extends ChildElement {
	private static final String TAG_NAME = "idArg";
	private static final String START_TAG = "<" + TAG_NAME + SymbolConstant.WHITESPACE_CHAR;

	private String javaType;
	private String column;
	private String jdbcType;
	private String typeHandler;
	/** associate other select sql id */
	private String select;
	/** associate other resultMap id */
	private String resultMap;
	private String columnPrefix;
	private String name;

	public IdArg() {
		super();
	}

	public IdArg(String javaType, String column, String jdbcType, String typeHandler, String select, String resultMap,
			String columnPrefix, String name) {
		this.javaType = javaType;
		this.column = column;
		this.jdbcType = jdbcType;
		this.typeHandler = typeHandler;
		this.select = select;
		this.resultMap = resultMap;
		this.columnPrefix = columnPrefix;
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder(START_TAG);
		append(s, "javaType", javaType, false);
		append(s, "column", column, false);
		append(s, "jdbcType", jdbcType, false);
		append(s, "typeHandler", typeHandler, false);
		append(s, "select", select, false);
		append(s, "resultMap", resultMap, false);
		append(s, "columnPrefix", columnPrefix, false);
		append(s, "name", name, false);
		deleteLastWhiteSpace(s);
		closeTag(s, true);
		return s.toString();
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

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getResultMap() {
		return resultMap;
	}

	public void setResultMap(String resultMap) {
		this.resultMap = resultMap;
	}

	public String getColumnPrefix() {
		return columnPrefix;
	}

	public void setColumnPrefix(String columnPrefix) {
		this.columnPrefix = columnPrefix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
