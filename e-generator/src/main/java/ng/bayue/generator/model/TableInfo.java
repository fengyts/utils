package ng.bayue.generator.model;

import java.util.List;

import ng.bayue.generator.config.Context;

/**
 * 表详细信息
 * @author lenovopc
 *
 */
public class TableInfo {

	/** 表名 */
	private String tableName;

	/** 表注释  */
	private String comment;

	/** 对应列 */
	private List<Column> columns;

	/** 表约束信息 */
	private ConstraintsInfo constraintsInfo;

	private Context context;

	public String getColumnStr() {
		String res = ColumnsInfoExtract.extractTableColumnsName(columns);
		return res;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public ConstraintsInfo getConstraintsInfo() {
		return constraintsInfo;
	}

	public void setConstraintsInfo(ConstraintsInfo constraintsInfo) {
		this.constraintsInfo = constraintsInfo;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
