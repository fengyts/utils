package ng.bayue.generator.constants;

import ng.bayue.generator.utils.StringUtils;

public final class Template {

	private static final String TEMPLATE_PATH = "src/main/template/";

	public static final String COMMON = "common.ftl";
	public static final String BASIC_MODEL = "basic_model.ftl";

	public static final String GENERIC_PAGE = "generic_page.ftl";
	public static final String GENERIC_DAO_EXCEPTION = "generic_dao_exception.ftl";
	public static final String GENERIC_SERVICE_EXCEPTION = "generic_service_exception.ftl";
	public static final String GENERIC_SERVICE = "generice_service.ftl";

	public static final String MB_CONSTANT = "mb_constant.ftl";
	public static final String MB_DAO = "mb_dao.ftl";
	public static final String MB_DAO_IMPL = "mb_dao_impl.ftl";
	public static final String MB_SERVICE = "mb_service.ftl";
	public static final String MB_SERVICE_IMPL = "mb_service_impl.ftl";
	public static final String MB_SQLMAP = "mb_sqlmap.ftl";

	public static final String MB_SQLMAP_CONFIG = "mb_sqlmap_config.ftl";

	private Template() {
	}

	public static String getTemplate(String templateTypeName) {
		if (StringUtils.isBlank(templateTypeName)) {
			throw new IllegalArgumentException("模板不存在");
		}
		return TEMPLATE_PATH + templateTypeName;
	}

}
