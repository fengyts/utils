package ng.bayue.generator.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

public class GeneratorFileUtil {

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
			File dir = new File(templatePath);
			File file = new File(fileName);
//			File templateFile = new File(templatePath + templateName);
//			if(!dir.exists()){
//				dir.mkdirs();
//			}
//			if(!file.exists()){
//				file.createNewFile();
//			}
//			if(!templateFile.exists()){
//				templateFile.createNewFile();
//			}
			
			Version incompatibleImprovements = new Version("2.3.28"); // freemarker 版本
			Configuration config = new Configuration(incompatibleImprovements);
			config.setDirectoryForTemplateLoading(dir);
			config.setObjectWrapper(new DefaultObjectWrapper(incompatibleImprovements));
			Template template = config.getTemplate(templateName, "UTF-8");
			FileOutputStream fos = new FileOutputStream(file);
			Writer out = new OutputStreamWriter(fos, "UTF-8");
			template.process(dataMap, out);
			out.flush();
			out.close();
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userName", "test create");
		userMap.put("userPassword", "123");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("user", userMap);
		String templatesPath = "E:/test/generate/webapp/template/";
		
		// 根据user.ftl模板生成user.html文件
		String templateFile = "/user.ftl";
		String htmlFile = templatesPath + "/user.html";
		GeneratorFileUtil.generateFile(templatesPath, templateFile, htmlFile, root);
		
	}

}
