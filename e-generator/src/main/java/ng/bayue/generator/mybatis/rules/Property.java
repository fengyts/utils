package ng.bayue.generator.mybatis.rules;

public class Property extends ChildElement {
	private String name;
	private String value;

	public Property(String name, String value) {
		validateRequiredString(name, value);
		this.name = name;
		this.value = value;
	}

	// <property name="" value="" />
	public String toString() {
		return toStringBuilder().toString();
	}

	public StringBuilder toStringBuilder() {
		StringBuilder property = new StringBuilder("<property ");
		append(property, "name", name, true);
		append(property, "value", value, true);
		property.append("/>");
		XMLFormatter.indent(property, formatter.getIndentProperty());
		XMLFormatter.newLine(property);
		return property;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}