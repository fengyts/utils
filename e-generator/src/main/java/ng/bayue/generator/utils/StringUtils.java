package ng.bayue.generator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

	public static final String WHITESPACE = " ";

	/**
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param cs
	 * @return
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * 下划线形式字符串转驼峰格式
	 * @param columnName
	 * @return
	 */
	public static String toHumpFormat(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return null;
		}
		char[] cs = columnName.toCharArray();

		boolean isAllUpperCase = true; // 是否全部大写的
		int lenCs = cs.length;
		for (int i = 0; i < lenCs; i++) {
			boolean l = Character.isLetter(cs[i]);
			if (l) {
				if (Character.isLowerCase(cs[i])) {
					isAllUpperCase = false;
					break;
				}
			}
		}

		if (isAllUpperCase) { // 大写全部转小写, 忽略小写中的部分
			columnName = columnName.toLowerCase();
		}

		String[] columns = columnName.split("_");
		int len = columns.length;
		final StringBuilder res = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String c = columns[i];
			if (c != null && c.trim().length() != 0) {
				if (res.length() == 0) {
					if (Character.isUpperCase(c.charAt(0))) {
						c = capitalLetterToLowerCase(c);
					}
					res.append(c);
					continue;
				}
				char[] sp = c.toCharArray();
				if (Character.isUpperCase(sp[0])) {
					res.append(sp);
				} else {
					sp[0] -= 32;
					res.append(sp);
				}
			}
		}
		return res.toString();
	}

	/**
	 * 驼峰形式转下划线格式，例如：TradeRecorde转成trade_recorde
	 * @param str
	 * @return
	 */
	public static String humpToLine(String str) {
		Pattern humpPattern = Pattern.compile("[A-Z]");
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			if (matcher.start(0) == 0) {
				matcher.appendReplacement(sb, matcher.group(0).toLowerCase());
			} else {
				matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String upperCaseCapitalLetter(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public static String lowerCaseCapitalLetter(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);
	}

	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String capitalLetterToUpperCase(String str) {
		final StringBuilder res = new StringBuilder();
		if (str != null && str.trim().length() != 0) {
			char[] sp = str.toCharArray();
			if (Character.isLetter(sp[0])) {
				if (Character.isUpperCase(sp[0])) {
					res.append(sp);
				} else {
					sp[0] -= 32;
					res.append(sp);
				}
			} else {
				return str;
			}
		}
		return res.toString();
	}

	public static String capitalLetterToLowerCase(String str) {
		final StringBuilder res = new StringBuilder();
		if (str != null && str.trim().length() != 0) {
			char[] sp = str.toCharArray();
			if (Character.isLetter(sp[0])) {
				if (Character.isLowerCase(sp[0])) {
					res.append(sp);
				} else {
					sp[0] += 32;
					res.append(sp);
				}
			} else {
				return str;
			}
		}
		return res.toString();
	}

}
