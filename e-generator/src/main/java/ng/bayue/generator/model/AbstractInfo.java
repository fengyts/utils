package ng.bayue.generator.model;

import ng.bayue.generator.utils.StringUtils;

public abstract class AbstractInfo {

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
