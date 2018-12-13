package ng.bayue.generator.gen;

import ng.bayue.generator.model.TableInfo;

public abstract class AbstractGenerator {

	protected TableInfo tableInfo;

	protected AbstractGenerator(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

	public TableInfo getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

}
