package ng.bayue.generator.config;

/**
 * 全局开关配置, 默认配置
 * @author lenovopc
 *
 */
public class ExtendSwitchConfiguration extends AbstractConfiguration {

	protected boolean uniqueEnable = DEFAULT_ENABLE;

	protected boolean unionUniqueModelEnable = uniqueEnable ? DEFAULT_ENABLE : DEFAULT_UNABLE;

	protected boolean isAbstractInterface = DEFAULT_ENABLE;

	protected boolean pageQueryEnable = DEFAULT_ENABLE;

	protected boolean batchEnable = DEFAULT_ENABLE;

	protected boolean extendSqlMapEnable = DEFAULT_ENABLE;

	public ExtendSwitchConfiguration() {
		super();
	}

	public boolean isUniqueEnable() {
		return uniqueEnable;
	}

	public void setUniqueEnable(boolean uniqueEnable) {
		this.uniqueEnable = uniqueEnable;
	}

	public boolean isUnionUniqueModelEnable() {
		return uniqueEnable && unionUniqueModelEnable;
		// return uniqueEnable ? unionUniqueModelEnable : DEFAULT_UNABLE;
		// return unionUniqueModelEnable;
	}

	public void setUnionUniqueModelEnable(boolean unionUniqueModelEnable) {
		this.unionUniqueModelEnable = uniqueEnable && unionUniqueModelEnable;
		// this.unionUniqueModelEnable = unionUniqueModelEnable;
	}

	public boolean isAbstractInterface() {
		return isAbstractInterface;
	}

	public void setAbstractInterface(boolean isAbstractInterface) {
		this.isAbstractInterface = isAbstractInterface;
	}

	public boolean isPageQueryEnable() {
		return pageQueryEnable;
	}

	public void setPageQueryEnable(boolean pageQueryEnable) {
		this.pageQueryEnable = pageQueryEnable;
	}

	public boolean isBatchEnable() {
		return batchEnable;
	}

	public void setBatchEnable(boolean batchEnable) {
		this.batchEnable = batchEnable;
	}

	public boolean isExtendSqlMapEnable() {
		return extendSqlMapEnable;
	}

	public void setExtendSqlMapEnable(boolean extendSqlMapEnable) {
		this.extendSqlMapEnable = extendSqlMapEnable;
	}

}
