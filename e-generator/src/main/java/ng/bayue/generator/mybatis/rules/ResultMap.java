package ng.bayue.generator.mybatis.rules;

/**
 * <!ELEMENT resultMap (constructor?,id*,result*,association*,collection*, discriminator?)>
	<!ATTLIST resultMap
	id CDATA #REQUIRED
	type CDATA #REQUIRED
	extends CDATA #IMPLIED
	autoMapping (true|false) #IMPLIED
	>
 * @author lenovopc
 *
 */
public class ResultMap extends BaseRule {
	/** #REQUIRED */
	private String id;
	/** #REQUIRED */
	private String type;
	private String extendsP;
	private boolean autoMapping;

	// private Id idInstance;
	// private Result result;
	// private Association association;
	// private Collection collection;
	// private Discriminator discriminator;

	public ResultMap() {
	}

	public ResultMap(String id, String type, String extendsP, boolean autoMapping) {
		validateRequiredString(id, type);
		this.id = id;
		this.type = type;
		this.extendsP = extendsP;
		this.autoMapping = autoMapping;
	}

	public String toString() {
		return null;
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

	public String getExtendsP() {
		return extendsP;
	}

	public void setExtendsP(String extendsP) {
		this.extendsP = extendsP;
	}

	public boolean isAutoMapping() {
		return autoMapping;
	}

	public void setAutoMapping(boolean autoMapping) {
		this.autoMapping = autoMapping;
	}

}