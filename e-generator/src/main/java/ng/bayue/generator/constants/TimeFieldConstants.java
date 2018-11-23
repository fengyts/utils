package ng.bayue.generator.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ng.bayue.generator.utils.StringUtils;

public final class TimeFieldConstants {

	private static final String[] CREATE_TIME_FIELD = new String[] { "gmt_created", "gmt_create", "create_time",
			"create_date", "created_time", "created_date", "add_time", "add_date" };

	private static final String[] MODIFIED_TIME_FIELD = new String[] { "gmt_modified", "gmt_modify", "modify_time",
			"modify_date", "modified_time", "modified_date", "update_time", "update_date" };

	private static final List<String> CREATE_TIME_FIELDS = new ArrayList<String>(Arrays.asList(CREATE_TIME_FIELD));

	private static final List<String> MODIFIED_TIME_FIELDS = new ArrayList<String>(Arrays.asList(MODIFIED_TIME_FIELD));

	public static boolean isCreateTimeField(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return false;
		}
		return CREATE_TIME_FIELDS.contains(columnName);
	}

	public static boolean isModifyTimeField(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return false;
		}
		return MODIFIED_TIME_FIELDS.contains(columnName);
	}

	public static boolean isCreateOrModifyTimeField(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			return false;
		}
		boolean c = isCreateTimeField(columnName);
		boolean m = isModifyTimeField(columnName);
		return c || m;
	}

}
