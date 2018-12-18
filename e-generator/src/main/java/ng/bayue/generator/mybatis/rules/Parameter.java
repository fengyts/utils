package ng.bayue.generator.mybatis.rules;

import ng.bayue.generator.utils.StringUtils;

public class Parameter extends BaseRule {
	/** #REQUIRED */
	private String property;
	private String javaType;
	private String jdbcType;
	/** 枚举类型：IN|OUT|INOUT默认为IN, 可以不填 */
	private String mode;
	private String resultMap;
	private String scale;
	private String typeHandler;

	public Parameter() {
	}

	public Parameter(String property, String javaType, String jdbcType, String mode, String resultMap, String scale,
			String typeHandler) {
		validateRequiredString(property);
		this.property = property;
		this.javaType = javaType;
		this.jdbcType = jdbcType;
		this.mode = mode;
		this.resultMap = resultMap;
		this.scale = scale;
		this.typeHandler = typeHandler;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		append(s, "property", property, true);
		if (StringUtils.isNotBlank(javaType)) {
			append(s, "javaType", javaType, false);
		}
		if (StringUtils.isNotBlank(jdbcType)) {
			append(s, "jdbcType", jdbcType, false);
		}
		if (StringUtils.isNotBlank(mode)) {
			append(s, "mode", mode, false);
		}
		if (StringUtils.isNotBlank(resultMap)) {
			append(s, "resultMap", resultMap, false);
		}
		if (StringUtils.isNotBlank(scale)) {
			append(s, "scale", scale, false);
		}
		if (StringUtils.isNotBlank(typeHandler)) {
			append(s, "typeHandler", typeHandler, false);
		}
		deleteLastWhiteSpace(s);
		closeTag(s, false);
		return s.toString();
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

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getResultMap() {
		return resultMap;
	}

	public void setResultMap(String resultMap) {
		this.resultMap = resultMap;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getTypeHandler() {
		return typeHandler;
	}

	public void setTypeHandler(String typeHandler) {
		this.typeHandler = typeHandler;
	}
}