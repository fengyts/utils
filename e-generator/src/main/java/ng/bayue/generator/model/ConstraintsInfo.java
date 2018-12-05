package ng.bayue.generator.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ng.bayue.generator.utils.StringUtils;

/**
 * 表约束信息
 * @author lenovopc
 *
 */
public class ConstraintsInfo {

	/** 主键约束信息 */
	private PrimaryKeyInfo pkInfo = new PrimaryKeyInfo();

	/** 唯一键约束信息  */
	// private List<UniqueKeyInfo> ukInfos;
	private Map<String, UniqueKeyInfo> ukInfosMap;

	/**
	 * 其他约束信息, 预留
	 * @return
	 */
	private List<? extends AbstractConstraints> others;

	public void addPrimaryKeyColumn(Column... columns) {
		if (null == pkInfo) {
			pkInfo = new PrimaryKeyInfo();
		}
		pkInfo.addColumn(columns);
	}

	public void addUniqueInfo(String uniqueIndexName, Column column) {
		if (StringUtils.isBlank(uniqueIndexName) || null == column) {
			throw new NullPointerException();
		}
		if (null == ukInfosMap) {
			ukInfosMap = new LinkedHashMap<String, UniqueKeyInfo>();
		}
		UniqueKeyInfo ukInfo = ukInfosMap.get(uniqueIndexName);
		if (null == ukInfo) {
			ukInfo = new UniqueKeyInfo();
		}
		ukInfo.setConstraintName(uniqueIndexName);
		ukInfo.addColumn(column);
		ukInfosMap.put(uniqueIndexName, ukInfo);
	}

	// ======================
	// methods setter and getter

	public PrimaryKeyInfo getPkInfo() {
		return pkInfo;
	}

	public void setPkInfo(PrimaryKeyInfo pkInfo) {
		this.pkInfo = pkInfo;
	}

	public Map<String, UniqueKeyInfo> getUkInfosMap() {
		return ukInfosMap;
	}

	public void setUkInfosMap(Map<String, UniqueKeyInfo> ukInfosMap) {
		this.ukInfosMap = ukInfosMap;
	}

	public List<? extends AbstractConstraints> getOthers() {
		return others;
	}

	public void setOthers(List<? extends AbstractConstraints> others) {
		this.others = others;
	}

}
