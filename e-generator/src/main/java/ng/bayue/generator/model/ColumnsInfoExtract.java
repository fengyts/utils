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
		return StringUtils.toHumpFormat(columnName);
	}


}
