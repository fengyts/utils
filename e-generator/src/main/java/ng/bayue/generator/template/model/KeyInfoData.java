package ng.bayue.generator.template.model;

import java.util.List;

public class KeyInfoData {

	/** 键的包名  */
	private String keyPackageName;
	private KeyInfo primaryKey;
	private List<KeyInfo> uniqueKey;

	public static class KeyInfo {
		/** 键的实体类全名称, 不含包名 */
		private String simpleClassName;
		/** 键的实体类全名称, 含包名  */
		private String fullClassName;

		public String getSimpleClassName() {
			return simpleClassName;
		}

		public void setSimpleClassName(String simpleClassName) {
			this.simpleClassName = simpleClassName;
		}

		public String getFullClassName() {
			return fullClassName;
		}

		public void setFullClassName(String fullClassName) {
			this.fullClassName = fullClassName;
		}

	}

	public String getKeyPackageName() {
		return keyPackageName;
	}

	public void setKeyPackageName(String keyPackageName) {
		this.keyPackageName = keyPackageName;
	}

	public KeyInfo getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(KeyInfo primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<KeyInfo> getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(List<KeyInfo> uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

}
