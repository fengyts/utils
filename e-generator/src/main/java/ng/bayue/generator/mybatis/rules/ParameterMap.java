package ng.bayue.generator.mybatis.rules;

import java.util.List;

public class ParameterMap extends BaseRule {
	private String id;
	private String type;
	private List<Parameter> parameters;

	public ParameterMap(String id, String type, List<Parameter> parameters) {
		validateRequiredString(id, type);
		this.id = id;
		this.type = type;
	}

	// <parameterMap type="" id="">
	// <parameter property="" javaType="" jdbcType="" mode="IN" resultMap=""
	// scale="" typeHandler=""/>
	// </parameterMap>
	public String toString() {
		StringBuilder s = new StringBuilder("<parameterMap ");
		append(s, "id", id, true);
		append(s, "type", type, true);
		deleteLastWhiteSpace(s);
		s.append(">");
		XMLFormatter.newLine(s);
		return s.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

}
