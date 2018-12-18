package ng.bayue.generator.mybatis.rules;

public abstract class ChildElement extends BaseRule {

	/** 子元素最少个数 */
	protected Integer childElementsLimitMinTimes;
	/** 子元素最多个数 */
	protected Integer childElementsLimitMaxTimes;

	protected ChildElement() {
		super();
	}

	public abstract String toString();

	public Integer getChildElementsLimitMinTimes() {
		return childElementsLimitMinTimes;
	}

	public void setChildElementsLimitMinTimes(Integer childElementsLimitMinTimes) {
		this.childElementsLimitMinTimes = childElementsLimitMinTimes;
	}

	public Integer getChildElementsLimitMaxTimes() {
		return childElementsLimitMaxTimes;
	}

	public void setChildElementsLimitMaxTimes(Integer childElementsLimitMaxTimes) {
		this.childElementsLimitMaxTimes = childElementsLimitMaxTimes;
	}

}
