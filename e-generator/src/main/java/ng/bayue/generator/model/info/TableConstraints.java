package ng.bayue.generator.model.info;

import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.utils.StringUtils;

/**
 * 表约束信息
 * @author lenovopc
 *
 */
@Deprecated
public class TableConstraints {

	/** 表名 */
	private String tableName;

	/** 主键约束, 一张表只能有一个主键约束 */
	private String pkConstraint;

	/** 唯一索引列(不包含主键), 一张表可以有多个unique */
	private List<String> uniqueConstraints;
	// private List<String> uniqueConstraints = new ArrayList<String>();

	/** 其他的(预留字段) */
	private List<String> otherKeyColumns;

	public void addUKConstraint(String uniqueConstraintName) {
		if (StringUtils.isNotBlank(uniqueConstraintName)) {
			if (null == uniqueConstraints) {
				uniqueConstraints = new ArrayList<String>();
			}
			uniqueConstraints.add(uniqueConstraintName);
		}
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPkConstraint() {
		return pkConstraint;
	}

	public void setPkConstraint(String pkConstraint) {
		this.pkConstraint = pkConstraint;
	}

	public List<String> getUniqueConstraints() {
		return uniqueConstraints;
	}

	public void setUniqueConstraints(List<String> uniqueConstraints) {
		this.uniqueConstraints = uniqueConstraints;
	}

	public List<String> getOtherKeyColumns() {
		return otherKeyColumns;
	}

	public void setOtherKeyColumns(List<String> otherKeyColumns) {
		this.otherKeyColumns = otherKeyColumns;
	}

}
