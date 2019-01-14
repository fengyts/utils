package ng.bayue.generator.information;

import ng.bayue.generator.types.JavaTypeInformation;
import ng.bayue.generator.utils.StringUtils;

/**
 * 表列信息
 * @author lenovopc
 *
 */
public class Column extends AbstractInfo {

	/** 列名 */
	private String columnName;
	/** 数据库类型 */
	private String jdbcTypeName;
	/** java实例属性-列名驼峰形式 */
	private String javaPropertyName;
	/** 列默认值 */
	private Object defaultValue;
	/** 列注释 */
	private String comment;

	// private String javaPropertyType;
	/** java属性类型信息 */
	private JavaTypeInformation javaTypeInfo;

	@Override
	public String getHumpFormat() {
		if (StringUtils.isNotBlank(humpFormat)) {
			return humpFormat;
		}
		return toHumpFormat(columnName);
	}

	// =================================
	// setter and getter methods

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

	public JavaTypeInformation getJavaTypeInfo() {
		return javaTypeInfo;
	}

	public void setJavaTypeInfo(JavaTypeInformation javaTypeInfo) {
		this.javaTypeInfo = javaTypeInfo;
	}

}
