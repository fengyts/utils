package ng.bayue.generator.mybatis.rules;

import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.utils.StringUtils;

public final class MapperDTDRules {

	private static XMLFormatter formatter = new XMLFormatter();

	public MapperDTDRules() {
	}

	public static void main(String[] args) {
		MapperDTDRules r = new MapperDTDRules();
		List<Property> properties = new ArrayList<Property>();
		Property p = new Property("name1", "value1");
		Property p1 = new Property("name2", "value2");
		Property p2 = new Property("name3", "value3");
		properties.add(p2);
		properties.add(p1);
		properties.add(p);

		Cache cache = new Cache("blocking", "eviction", "flushInterval", "readOnly", "size", "type", properties);
		String sql = cache.toString();
		System.out.println(sql);

		// Cache c1 = new Cache();
		// c1.setBlocking("b1");
		// c1.setSize("10");
		// System.out.println(c1.toString());

		// String ps = concatProperties(properties).toString();
		// System.out.println(ps);
	}

	public static class RootMapper {
		private String namespace;
		private CacheRef cacheRef;
		private Cache cache;
	}

	public static class CacheRef {
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

	public static class Cache {
		private String blocking;
		private String eviction;
		private String flushInterval;
		private String readOnly;
		private String size;
		private String type;

		private List<Property> properties;

		public Cache() {
			super();
		}

		public Cache(String blocking, String eviction, String flushInterval, String readOnly, String size, String type,
				List<Property> properties) {
			this.blocking = blocking;
			this.eviction = eviction;
			this.flushInterval = flushInterval;
			this.readOnly = readOnly;
			this.size = size;
			this.type = type;
			this.properties = properties;
		}

		public String toString() {
			final StringBuilder cache = new StringBuilder("<cache ");
			append(cache, "blocking", blocking, false);
			append(cache, "eviction", eviction, false);
			append(cache, "flushInterval", flushInterval, false);
			append(cache, "readOnly", readOnly, false);
			append(cache, "size", size, false);
			append(cache, "type", type, false);
			deleteLastWhiteSpace(cache);
			cache.append(">");
			XMLFormatter.newLine(cache);
			// cache.append(concatProperties(properties));
			appendProperty(cache, properties);
			XMLFormatter.indent(cache, formatter.getIndentSqlElement());
			XMLFormatter.newLineIndent(cache, formatter.getIndentSqlElement(), "</cache>");

			return cache.toString();
		}

		public String getBlocking() {
			return blocking;
		}

		public void setBlocking(String blocking) {
			this.blocking = blocking;
		}

		public String getEviction() {
			return eviction;
		}

		public void setEviction(String eviction) {
			this.eviction = eviction;
		}

		public String getFlushInterval() {
			return flushInterval;
		}

		public void setFlushInterval(String flushInterval) {
			this.flushInterval = flushInterval;
		}

		public String getReadOnly() {
			return readOnly;
		}

		public void setReadOnly(String readOnly) {
			this.readOnly = readOnly;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Property> getProperties() {
			return properties;
		}

		public void setProperties(List<Property> properties) {
			this.properties = properties;
		}
	}

	public static class ParameterMap {
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

	public static class Property {
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

	public static class Parameter {
	}

	private static String toStringKV(String keyName, String value) {
		validateRequiredString(keyName, value);
		return keyName + "=\"" + value + "\" ";
	}

	private static void validateRequiredString(String... strs) {
		if (null == strs || strs.length == 0) {
			throw new NullPointerException();
		}
		for (String str : strs) {
			if (StringUtils.isBlank(str)) {
				throw new NullPointerException();
			}
		}
	}

	private static void append(StringBuilder b, String keyName, String value, boolean required) {
		if (required) {
			b.append(toStringKV(keyName, value));
		} else {
			validateRequiredString(keyName);
			if (StringUtils.isNotBlank(value)) {
				b.append(toStringKV(keyName, value));
			}
		}
	}

	private static void appendProperty(StringBuilder b, List<Property> properties) {
		b.append(concatProperty(properties));
	}

	private static void deleteLastWhiteSpace(StringBuilder b) {
		int len = null == b ? 0 : b.length();
		if (len > 0) {
			b.deleteCharAt(len - 1);
		}
	}

	private static StringBuilder concatProperty(List<Property> properties) {
		StringBuilder sp = new StringBuilder();
		if (null == properties || properties.size() == 0) {
			return sp;
		}
		for (Property p : properties) {
			sp.append(p.toString());
		}
		return sp;
	}

	private static void createStartTag(StringBuilder s, String propertyName, String propertyValue,
			boolean isSingleTag) {
		if (null == s) {
			throw new NullPointerException();
		}
	}

}
