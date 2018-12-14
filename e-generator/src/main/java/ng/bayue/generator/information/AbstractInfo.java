package ng.bayue.generator.information;

import ng.bayue.generator.utils.StringUtils;

public abstract class AbstractInfo {

	/** 表名|列名 java驼峰形式 */
	protected String humpFormat;

	protected abstract String getHumpFormat();

	protected String toHumpFormat(String dashFormat) {
		if (StringUtils.isBlank(dashFormat)) {
			return null;
		}
		humpFormat = StringUtils.toHumpFormat(dashFormat);
		return humpFormat;
	}

	public void setHumpFormat(String humpFormat) {
		this.humpFormat = humpFormat;
	}

}
