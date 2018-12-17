package ng.bayue.generator.information;

import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.TableConfiguration;
import ng.bayue.generator.utils.StringUtils;

/**
 * 表详细信息
 * @author lenovopc
 *
 */
public class TableInfo extends AbstractInfo {

	/** 表名 */
	private String tableName;

	/** 表注释  */
	private String comment;

	/** 对应列 */
	private List<Column> columns = new ArrayList<Column>();

	/** 表约束信息 */
	private ConstraintsInfo constraintsInfo;

	private Context context;

	public TableInfo(Context context) {
		this.context = context;
	}

	public TableConfiguration getTableConfiguration() {
		return context.getTableConfiguration(tableName);
	}

	public String getColumnStr() {
		String res = ColumnsInfoExtract.extractTableColumnsName(columns);
		return res;
	}

	public Column getColumnByName(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			throw new NullPointerException();
		}
		for (Column c : columns) {
			if (columnName.equals(c.getColumnName())) {
				return c;
			}
		}
		return null;
	}

	public void addPrimaryKeyConstraints(Column... columns) {
		initTableConstraintsInfo();
		constraintsInfo.addPrimaryKeyColumn(columns);
	}

	public void addUniqueConstraints(String uniqueIndexName, Column column) {
		initTableConstraintsInfo();
		constraintsInfo.addUniqueInfo(uniqueIndexName, column);
	}

	private void initTableConstraintsInfo() {
		if (constraintsInfo == null) {
			constraintsInfo = new ConstraintsInfo();
		}
	}

	@Override
	public String getHumpFormat() {
		super.toHumpFormat(tableName);
		return humpFormat;
	}

	// ===================================
	// methods setter and getter

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

}
