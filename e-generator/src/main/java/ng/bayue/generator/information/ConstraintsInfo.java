package ng.bayue.generator.information;

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
	// private List<UniqueKeyInfo> uniqueInfos;
	private Map<String, UniqueKeyInfo> uniqueInfosMap;

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
		if (null == uniqueInfosMap) {
			uniqueInfosMap = new LinkedHashMap<String, UniqueKeyInfo>();
		}
		UniqueKeyInfo ukInfo = uniqueInfosMap.get(uniqueIndexName);
		if (null == ukInfo) {
			ukInfo = new UniqueKeyInfo();
		}
		ukInfo.setConstraintName(uniqueIndexName);
		ukInfo.addColumn(column);
		uniqueInfosMap.put(uniqueIndexName, ukInfo);
	}
	
	public boolean isUnionPK() {
		return pkInfo.isUnionKey();
	}

//	/**
//	 * 是否单一列唯一索引
//	 * @return true: 单一列唯一索引；false: 联合唯一索引
//	 */
//	public boolean isUnionUnique() {
//		if(ukInfosMap == null){
//			return false;
//		}
//		boolean isUnionUnique = true;
//		if(ukInfosMap.size() == 1){
//			
//			return true;
//		}
//		return true;
//	}

	// ======================
	// methods setter and getter

	public PrimaryKeyInfo getPkInfo() {
		return pkInfo;
	}

	public void setPkInfo(PrimaryKeyInfo pkInfo) {
		this.pkInfo = pkInfo;
	}

	public Map<String, UniqueKeyInfo> getUniqueInfosMap() {
		return uniqueInfosMap;
	}

	public void setUniqueInfosMap(Map<String, UniqueKeyInfo> uniqueInfosMap) {
		this.uniqueInfosMap = uniqueInfosMap;
	}

	public List<? extends AbstractConstraints> getOthers() {
		return others;
	}

	public void setOthers(List<? extends AbstractConstraints> others) {
		this.others = others;
	}

}
