package ng.bayue.generator.template.model;

import java.util.List;
import java.util.Set;

public class KeyInfoData {

	private KeyInfo primaryKey;
	private List<KeyInfo> uniqueKey;
	private boolean isUnionPK = false;
	private boolean hasUniqueKey = false;

	public static class KeyInfo {
		/** 键的实体类名称, 不含包名 */
		private String keyClassSimpleName;
		/** 键的实体类全名称, 含包名  */
		private String keyClassFullyName;
		private Set<String> imports;
		private List<EntityProperty> properties;
		private boolean isUnion = false;

		public String getKeyClassSimpleName() {
			return keyClassSimpleName;
		}

		public void setKeyClassSimpleName(String keyClassSimpleName) {
			this.keyClassSimpleName = keyClassSimpleName;
		}

		public String getKeyClassFullyName() {
			return keyClassFullyName;
		}

		public void setKeyClassFullyName(String keyClassFullyName) {
			this.keyClassFullyName = keyClassFullyName;
		}

		public Set<String> getImports() {
			return imports;
		}

		public void setImports(Set<String> imports) {
			this.imports = imports;
		}

		public List<EntityProperty> getProperties() {
			return properties;
		}

		public void setProperties(List<EntityProperty> properties) {
			this.properties = properties;
		}

		public boolean getIsUnion() {
			return isUnion;
		}

		public void setIsUnion(boolean isUnion) {
			this.isUnion = isUnion;
		}

	}

	public boolean isUnionPK() {
		return isUnionPK;
	}

	public void setUnionPK(boolean isUnionPK) {
		this.isUnionPK = isUnionPK;
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

	public boolean isHasUniqueKey() {
		return hasUniqueKey;
	}

	public void setHasUniqueKey(boolean hasUniqueKey) {
		this.hasUniqueKey = hasUniqueKey;
	}

}
