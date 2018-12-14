package ng.bayue.generator.gen.handler;

import ng.bayue.generator.information.TableInfo;

public class ConstraintsInfoHandler {

	private TableInfo tableInfo;

	public ConstraintsInfoHandler(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

	public TableInfo getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

}
