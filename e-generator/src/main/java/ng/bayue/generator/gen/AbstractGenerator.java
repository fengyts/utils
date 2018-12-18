package ng.bayue.generator.gen;

import ng.bayue.generator.information.TableInfo;

public abstract class AbstractGenerator {

	protected TableInfo tableInfo;

	protected AbstractGenerator(TableInfo tableInfo) {
		if (null == tableInfo) {
			throw new NullPointerException();
		}
		this.tableInfo = tableInfo;
	}

	public TableInfo getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

}
