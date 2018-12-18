package ng.bayue.generator.mybatis.rules;

import ng.bayue.generator.utils.StringUtils;

public class CacheRef {
	private String namespace;

	public CacheRef(String namespace) {
		this.namespace = namespace;
	}

	public String toString() {
		if (StringUtils.isBlank(namespace)) {
			return "";
		}
		return "<cache-ref namespace=\"" + namespace + "\" />";
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

}
