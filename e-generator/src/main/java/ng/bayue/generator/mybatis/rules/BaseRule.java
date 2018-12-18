package ng.bayue.generator.mybatis.rules;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.constants.SymbolConstant;
import ng.bayue.generator.utils.StringUtils;

public abstract class BaseRule {

	protected static XMLFormatter formatter = new XMLFormatter();

	private static String toStringKV(String keyName, String value) {
		validateRequiredString(keyName, value);
		return keyName + "=\"" + value + "\" ";
	}

	public static void validateRequiredString(String... strs) {
		if (null == strs || strs.length == 0) {
			throw new NullPointerException();
		}
		for (String str : strs) {
			if (StringUtils.isBlank(str)) {
				throw new NullPointerException();
			}
		}
	}

	public static void append(StringBuilder s, String keyName, String value, boolean required) {
		if (required) {
			s.append(toStringKV(keyName, value));
		} else {
			validateRequiredString(keyName);
			if (StringUtils.isNotBlank(value)) {
				s.append(toStringKV(keyName, value));
			}
		}
	}

	public static void appendProperty(StringBuilder s, List<Property> properties) {
		s.append(concatProperty(properties));
	}

	public static void deleteLastWhiteSpace(StringBuilder s) {
		int len = null == s ? 0 : s.length();
		if (len > 0) {
			s.deleteCharAt(len - 1);
		}
	}

	public static StringBuilder concatProperty(List<Property> properties) {
		StringBuilder sp = new StringBuilder();
		if (null == properties || properties.size() == 0) {
			return sp;
		}
		for (Property p : properties) {
			sp.append(p.toString());
		}
		return sp;
	}

	private static void createStartTag(StringBuilder s, String tagName, String propertyName, String propertyValue) {
		if (null == s) {
			throw new NullPointerException();
			// if (StringUtils.isBlank(tagName)) {
			// throw new NullPointerException();
			// }
			// s = new StringBuilder();
			// s.append(SymbolConstant.ANGLE_BRACKET_LEFT).append(tagName).append(SymbolConstant.WHITESPACE_CHAR);
		} else {
			if (s.length() == 0) {
				if (StringUtils.isBlank(tagName)) {
					throw new NullPointerException();
				}
				s.append(SymbolConstant.ANGLE_BRACKET_LEFT).append(tagName).append(SymbolConstant.WHITESPACE_CHAR);
			}
		}
		validateRequiredString(propertyName);
		if (StringUtils.isNotBlank(propertyValue)) {
			append(s, propertyName, propertyValue, false);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> void createStartTag(StringBuilder s, T instance, String tagName, int tagLevel) {
		if (null == s || StringUtils.isBlank(tagName) || null == instance) {
			throw new NullPointerException();
		}
		if (s.length() == 0) {
			if (StringUtils.isBlank(tagName)) {
				throw new NullPointerException();
			}
			s.append(SymbolConstant.ANGLE_BRACKET_LEFT).append(tagName).append(SymbolConstant.WHITESPACE_CHAR);
		}
		try {
			Class<?> clazz = instance.getClass();
			Field[] fields = clazz.getDeclaredFields();
			String propertyName, propertyValue;
			List<Property> properties = null;
			Object obj;
			for (Field f : fields) {
				if (!f.isAccessible()) {
					f.setAccessible(true);
				}
				int modifiers = f.getModifiers();
				if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
					continue;
				}
				propertyName = f.getName();
				obj = f.get(instance);
				if (obj instanceof String) {
					propertyValue = (String) obj;
					if (StringUtils.isNotBlank(propertyValue)) {
						append(s, propertyName, propertyValue, false);
					}
				} else if (obj instanceof Boolean) {
					propertyValue = String.valueOf(obj);
				} else if (obj instanceof ArrayList) {
					properties = (List<Property>) obj;
				} else {
					propertyValue = String.valueOf(obj);
				}
			}
			deleteLastWhiteSpace(s);
			int indentLevel = formatter.getIndentSqlElement();
			XMLFormatter.indent(s, indentLevel);
			if (null == properties || properties.size() == 0) {
				closeTag(s, true);
			} else {
				closeTag(s, false);
				XMLFormatter.newLine(s);
				appendProperty(s, properties);
				closeTagByTagName(s, tagName, indentLevel);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void closeTag(StringBuilder s, boolean isSingleTag) {
		if (isSingleTag) {
			s.append(" />");
		} else {
			s.append(">");
		}
	}

	private static void closeTagByTagName(StringBuilder s, String tagName, int indentLevel) {
		StringBuilder endTag = new StringBuilder();
		endTag.append(SymbolConstant.ANGLE_BRACKET_LEFT).append(SymbolConstant.SPRIT).append(tagName)
				.append(SymbolConstant.ANGLE_BRACKET_RIGHT);
		XMLFormatter.indent(endTag, indentLevel);
		s.append(endTag);
	}

	public static void addChildElementId(Id... ids) {
	}

	public static void addChildElementConstructor(Constructor... constructors) {
	}

	public static void addChildElementResult(Result... results) {
	}

	public static void addChildElementAssociation(Association... associations) {
	}

	public static void addChildElementCollection(Collection... collections) {
	}

	public static void addChildElementDiscriminator(Discriminator... discriminators) {
	}

}
