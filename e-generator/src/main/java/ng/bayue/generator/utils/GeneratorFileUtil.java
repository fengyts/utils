package ng.bayue.generator.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import ng.bayue.generator.template.model.TemplateDataModelMapper.TemplateMapperEnum;

public class GeneratorFileUtil {

	private static final String CHARACTER_UTF8 = "UTF-8";
	// freemarker版本: new Version("2.3.28")
	private static final Version INCOMPATIBLE_IMPROVEMENTS = Configuration.VERSION_2_3_28;

	public static void createJaveSourceFile(String path, String fileName, String writeString) throws IOException {
		String allPath = path + File.separator + fileName;
		File file = new File(allPath);
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		out.write(writeString.getBytes());
		out.flush();
		out.close();
	}

	/**
	 * 根据模板生成文件
	 * 
	 * @param templatePath
	 *            模板路径
	 * @param templateName
	 *            模板名称
	 * @param fileName
	 *            要生成的文件名
	 * @param root
	 *            输出的内容
	 */
	public static void generateFile(String templatePath, String templateName, String fileName, Map<?, ?> dataMap) {
		try {
			Configuration config = new Configuration(INCOMPATIBLE_IMPROVEMENTS);
			config.setObjectWrapper(new DefaultObjectWrapper(INCOMPATIBLE_IMPROVEMENTS));

			// 加载egenerator.jar中的ftl模板文件
			config.setDirectoryForTemplateLoading(new File(templatePath));

			generateFileByTemplate(config, templateName, fileName, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generateFile(String templateName, String fileName, Map<?, ?> dataMap) {
		try {
			Configuration config = new Configuration(INCOMPATIBLE_IMPROVEMENTS);
			config.setObjectWrapper(new DefaultObjectWrapper(INCOMPATIBLE_IMPROVEMENTS));

			// 加载egenerator.jar中的ftl模板文件
			// TemplateLoader templateLoader = new
			// ClassTemplateLoader(GeneratorTemplate.class, "/template");
			TemplateLoader templateLoader = new ClassTemplateLoader(Template.class, "/template");
			config.setTemplateLoader(templateLoader);

			generateFileByTemplate(config, templateName, fileName, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generateFile(TemplateMapperEnum tme, String fileName, Map<?, ?> dataMap) {
		try {
			Configuration config = new Configuration(INCOMPATIBLE_IMPROVEMENTS);
			config.setObjectWrapper(new DefaultObjectWrapper(INCOMPATIBLE_IMPROVEMENTS));

			// 加载egenerator.jar中的ftl模板文件
			// TemplateLoader templateLoader = new
			// ClassTemplateLoader(GeneratorTemplate.class, "/template");
			TemplateLoader templateLoader = new ClassTemplateLoader(Template.class, "/template");
			config.setTemplateLoader(templateLoader);

			String templateName = tme.getTemplateName();
			String fileNameFull = tme.handleFileName(fileName);
			generateFileByTemplate(config, templateName, fileNameFull, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void generateFileByTemplate(Configuration config, String templateName, String fileName,
			Map<?, ?> dataMap) {
		try {
			Template template = config.getTemplate(templateName, CHARACTER_UTF8);
			FileOutputStream fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, CHARACTER_UTF8);
			template.process(dataMap, out);
			out.flush();
			out.close();
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDirectory(final File directory) {
		try {
			if (!directory.exists()) {
				return;
			}
			cleanDirectory(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void cleanDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}
		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}
		File[] files = directory.listFiles();
		if (files == null) { // null if security restricted
			throw new IOException("Failed to list contents of " + directory);
		}
		IOException exception = null;
		for (File file : files) {
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}
		if (null != exception) {
			throw exception;
		}
	}

	private static void forceDelete(File file) throws IOException {
		if (file.isDirectory()) {
			deleteDirectory(file);
		} else {
			boolean filePresent = file.exists();
			if (!file.delete()) {
				if (!filePresent) {
					throw new FileNotFoundException("File does not exist: " + file);
				}
				String message = "Unable to delete file: " + file;
				throw new IOException(message);
			}
		}
	}

	// public static void main(String[] args) {
	// Map<String, String> userMap = new HashMap<String, String>();
	// userMap.put("userName", "test create");
	// userMap.put("userPassword", "123");
	//
	// Map<String, Object> root = new HashMap<String, Object>();
	// root.put("user", userMap);
	// String templatesPath = "E:/test/generate/webapp/template/";
	//
	// // 根据user.ftl模板生成user.html文件
	// String templateFile = "/user.ftl";
	// String htmlFile = templatesPath + "/user.html";
	// GeneratorFileUtil.generateFile(templatesPath, templateFile, htmlFile,
	// root);
	// }

}
