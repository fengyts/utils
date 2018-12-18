package ng.bayue.generator.mybatis.rules;

import java.util.ArrayList;
import java.util.List;

public final class MapperDTDRules {

	// private static XMLFormatter formatter = new XMLFormatter();

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

		// Cache cache = new Cache("blocking", "eviction", "flushInterval", "",
		// "size", null, null);
		// String sql = cache.toString();
		// System.out.println(sql);
		//
		// StringBuilder s = new StringBuilder("<cache ");
		// createStartTag(s, cache, "cache", 1);
		// System.out.println(s);

		// Parameter parameter = new Parameter("property", "java.lang.String",
		// "jdbcType", "IN", "BaseResultMap", "1", "StringTypeHandler");
		// System.out.println(parameter.toString());

		// Id id = new Id("property", "javaType", "column", "jdbcType",
		// "typeHandler");
		// System.out.println(id.toString());

		// IdArg idArg = new IdArg();
		// idArg.setName("name");
		// idArg.setJavaType("java.lang.String");
		// idArg.setSelect("selectById");
		// System.out.println(idArg.toString());
	}

	public static class RootMapper {
		private String namespace;
		private CacheRef cacheRef;
		private Cache cache;
	}

}
