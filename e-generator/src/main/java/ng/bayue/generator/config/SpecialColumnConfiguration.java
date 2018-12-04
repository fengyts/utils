package ng.bayue.generator.config;

public class SpecialColumnConfiguration extends AbstractConfiguration {

	// private String columnName;
	// private String columnTypeName;
	// private int columnType;
	// private int columnLength;
	// private String javaPropertyType;

	private int columnLength;

	private boolean tinyintToBooleanEnable;

	public boolean isTinyintToBooleanEnable() {
		return tinyintToBooleanEnable;
	}

	public void setTinyintToBooleanEnable(Boolean tinyintToBooleanEnable) {
		if(null == tinyintToBooleanEnable){
			tinyintToBooleanEnable = columnLength <= 1;
		}
		this.tinyintToBooleanEnable = tinyintToBooleanEnable;
	}

	public int getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(int columnLength) {
		this.columnLength = columnLength;
	}
	
}
