package ng.bayue.generator.constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import ng.bayue.generator.utils.StringUtils;

public final class GeneratorTemplate {

	private static final String TEMPLATE_PATH = "src/main/template/";

	public static final String COMMON = "common_g.ftl";
	public static final String BASIC_MODEL = "basic_model.ftl";

	public static final String GENERIC_PAGE = "generic_page.ftl";
	public static final String GENERIC_DAO_EXCEPTION = "generic_dao_exception.ftl";
	public static final String GENERIC_SERVICE_EXCEPTION = "generic_service_exception.ftl";
	public static final String GENERIC_SERVICE = "generic_service.ftl";

	public static final String MB_CONSTANT = "mb_constant.ftl";

	// base - base
	public static final String MB_KEY = "mb_key.ftl";
	public static final String MB_MODEL = "mb_model.ftl";
	public static final String MB_DAO = "mb_dao.ftl";
	public static final String MB_SQLMAP = "mb_sqlmap.ftl";

	// extends
	public static final String MB_DAO_IMPL = "mb_dao_impl.ftl";
	public static final String MB_SERVICE = "mb_service.ftl";
	public static final String MB_SERVICE_IMPL = "mb_service_impl.ftl";

	// unique
	public static final String MB_DAO_UNIQUE = "mb_dao_unique.ftl";
	public static final String MB_DAO_UNIQUE_IMPL = "mb_dao_unique_impl.ftl";
	public static final String MB_SERVICE_UNIQUE = "mb_service_unique.ftl";
	public static final String MB_SERVICE_UNIQUE_IMPL = "mb_service_unique_impl.ftl";

	// batch
	public static final String MB_DAO_BATCH = "mb_dao_batch.ftl";
	public static final String MB_DAO_BATCH_IMPL = "mb_dao_batch_impl.ftl";
	public static final String MB_SERVICE_BATCH = "mb_service_batch.ftl";
	public static final String MB_SERVICE_BATCH_IMPL = "mb_service_batch_impl.ftl";

	public static final String MB_SQLMAP_CONFIG = "mb_sqlmap_config.ftl";

	private GeneratorTemplate() {
	}

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

			// URL fileURL = GeneratorTemplate.class.getResource("/template/" +
			// MB_SERVICE);
			// System.out.println(fileURL.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
