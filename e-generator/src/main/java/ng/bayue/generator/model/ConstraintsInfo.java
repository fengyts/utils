package ng.bayue.generator.model;

import java.util.List;

/**
 * 表约束信息
 * @author lenovopc
 *
 */
public class ConstraintsInfo {

	/** 主键约束信息 */
	private PrimaryKeyInfo pkInfo;

	/** 唯一键约束信息  */
	private List<UniqueKeyInfo> ukInfos;

	/**
	 * 其他约束信息, 预留
	 * @return
	 */
	private List<? extends AbstractConstraints> others;

	public PrimaryKeyInfo getPkInfo() {
		return pkInfo;
	}

	public void setPkInfo(PrimaryKeyInfo pkInfo) {
		this.pkInfo = pkInfo;
	}

	public List<UniqueKeyInfo> getUkInfos() {
		return ukInfos;
	}

	public void setUkInfos(List<UniqueKeyInfo> ukInfos) {
		this.ukInfos = ukInfos;
	}

	public List<? extends AbstractConstraints> getOthers() {
		return others;
	}

	public void setOthers(List<? extends AbstractConstraints> others) {
		this.others = others;
	}

}
