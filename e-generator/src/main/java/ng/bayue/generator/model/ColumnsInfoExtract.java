package ng.bayue.generator.model;

import java.util.List;

import ng.bayue.generator.utils.StringUtils;

public class ColumnsInfoExtract {

	public static String extractTableColumnsName(List<Column> columns) {
		final StringBuilder columnStr = new StringBuilder();
		if (null == columns) {
			return columnStr.toString();
		}
		for (Column c : columns) {
			columnStr.append(c.getColumnName()).append(",");
		}
		final String res = columnStr.substring(0, columnStr.length() - 1);
		return res;
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