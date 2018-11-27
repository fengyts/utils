package ng.bayue.generator.model;

import java.util.List;

/**
 * 表约束信息
 * @author lenovopc
 *
 */
public abstract class AbstractConstraints {

	protected String tableName;
	/** 约束名称 */
	protected String constraintName;
	/** 约束类型 */
	protected String constraintType;
	/** 键对应的列名 */
	protected List<Column> columns;

	/** 是否联合键 */
	protected boolean isUnion;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}

	public String getConstraintType() {
		return constraintType;
	}

	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public boolean isUnion() {
		return isUnion;
	}

	public void setUnion(boolean isUnion) {
		this.isUnion = isUnion;
	}

}
