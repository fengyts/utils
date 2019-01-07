package ng.bayue.generator.config;

/**
 * 全局开关配置, 默认配置
 * @author lenovopc
 *
 */
public class ExtendSwitchConfiguration extends AbstractConfiguration {

	protected boolean uniqueEnable = DEFAULT_ENABLE;

	protected boolean unionUniqueModelEnable = uniqueEnable ? DEFAULT_ENABLE : DEFAULT_UNABLE;

	protected boolean serviceEnable = DEFAULT_ENABLE;

	protected boolean abstractInterfaceEnable = DEFAULT_ENABLE;

	/** dao interface generated implement class switch */
	protected boolean daoImplementEnable = DEFAULT_ENABLE;

	protected boolean pageQueryEnable = DEFAULT_ENABLE;

	protected boolean batchEnable = DEFAULT_ENABLE;

	protected boolean extendSqlMapingEnable = DEFAULT_ENABLE;

	/** sql mapping file name first capital letter switch, default false, mean that file name first letter is lowercase */
	protected boolean sqlMappingFileNameCapital = DEFAULT_UNABLE;

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

	public boolean isServiceEnable() {
		return serviceEnable;
	}

	public void setServiceEnable(boolean serviceEnable) {
		this.serviceEnable = serviceEnable;
	}

	public boolean isAbstractInterfaceEnable() {
		return abstractInterfaceEnable;
	}

	public void setAbstractInterfaceEnable(boolean abstractInterfaceEnable) {
		this.abstractInterfaceEnable = abstractInterfaceEnable;
	}

	public boolean isDaoImplementEnable() {
		return daoImplementEnable;
	}

	public void setDaoImplementEnable(boolean daoImplementEnable) {
		this.daoImplementEnable = daoImplementEnable;
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

	public boolean isExtendSqlMapingEnable() {
		return extendSqlMapingEnable;
	}

	public void setExtendSqlMapingEnable(boolean extendSqlMapingEnable) {
		this.extendSqlMapingEnable = extendSqlMapingEnable;
	}

	public boolean isSqlMappingFileNameCapital() {
		return sqlMappingFileNameCapital;
	}

	public void setSqlMappingFileNameCapital(boolean sqlMappingFileNameCapital) {
		this.sqlMappingFileNameCapital = sqlMappingFileNameCapital;
	}

}
