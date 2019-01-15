package ng.bayue.generator.constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import ng.bayue.generator.utils.StringUtils;

public final class GeneratorTemplate {

	// private static final String TEMPLATE_PATH = "src/main/template/";

	public static final String COMMON_G = "common_g.ftl";
	public static final String GENERIC_MODEL_BASIC = "generic_model_basic.ftl";
	
	// base -> common
	public static final String GENERIC_PAGE = "generic_page.ftl";
	public static final String GENERIC_DAO_EXCEPTION = "generic_dao_exception.ftl";
	public static final String GENERIC_SERVICE_EXCEPTION = "generic_service_exception.ftl";
	public static final String GENERIC_DAO_BASIC = "generic_dao_basic.ftl";
	public static final String GENERIC_DAO_IMPL = "generic_dao_impl.ftl";
	public static final String GENERIC_DAO_IMPL_BASIC = "generic_dao_impl_basic.ftl";
	public static final String GENERIC_SERVICE = "generic_service.ftl";
	public static final String GENERIC_SERVICE_IMPL = "generic_service_impl.ftl";

	public static final String MB_CONSTANT = "mb_constant.ftl";

	// base -> base
	public static final String MB_KEY = "mb_key.ftl";
	public static final String MB_MODEL = "mb_model.ftl";
	public static final String MB_DAO = "mb_dao.ftl";
	public static final String MB_SQLMAP = "mb_sqlmap.ftl";

	// extends -> service
	public static final String MB_DAO_IMPL = "mb_dao_impl.ftl";
	public static final String MB_SERVICE = "mb_service.ftl";
	public static final String MB_SERVICE_IMPL = "mb_service_impl.ftl";

	// extends -> unique
	public static final String MB_DAO_UNIQUE = "extends/mb_dao_unique.ftl";
	public static final String MB_DAO_UNIQUE_IMPL = "extends/mb_dao_unique_impl.ftl";
	public static final String MB_SERVICE_UNIQUE = "extends/mb_service_unique.ftl";
	public static final String MB_SERVICE_UNIQUE_IMPL = "extends/mb_service_unique_impl.ftl";

	// extends -> batch
	public static final String MB_DAO_BATCH = "extends/mb_dao_batch.ftl";
	public static final String MB_DAO_BATCH_IMPL = "extends/mb_dao_batch_impl.ftl";
	public static final String MB_SERVICE_BATCH = "extends/mb_service_batch.ftl";
	public static final String MB_SERVICE_BATCH_IMPL = "extends/mb_service_batch_impl.ftl";

	public static final String MB_SQLMAP_CONFIG = "mb_sqlmap_config.ftl";

	private GeneratorTemplate() {
	}

	/**
	 * 获取文件模板
	 * @param templateName
	 * @return
	 */
	public static String getTemplateResource(String templateName) {
		try {
			if (StringUtils.isBlank(templateName)) {
				throw new NullPointerException();
			}
			InputStream is = GeneratorTemplate.class.getResourceAsStream("/template/" + templateName);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			final StringBuilder s = new StringBuilder();
			while ((line = br.readLine()) != null) {
				s.append(line);
				// System.out.println(s);
			}
			return s.toString();

			// java.net.URL fileURL = GeneratorTemplate.class.getResource("/template/" +  MB_SERVICE);
			// System.out.println(fileURL.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
