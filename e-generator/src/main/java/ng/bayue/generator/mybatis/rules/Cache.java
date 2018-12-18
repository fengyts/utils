package ng.bayue.generator.mybatis.rules;

import java.util.List;

public class Cache extends BaseRule {
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