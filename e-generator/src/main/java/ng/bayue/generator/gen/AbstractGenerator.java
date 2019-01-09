package ng.bayue.generator.gen;

import java.util.List;
import java.util.Map;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.GlobalConfiguration;
import ng.bayue.generator.constants.JavaVisibility;
import ng.bayue.generator.constants.SymbolConstant;
import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TemplateDataModelMapper.TemplateMapperEnum;
import ng.bayue.generator.utils.GeneratorFileUtil;
import ng.bayue.generator.utils.StringUtils;

public abstract class AbstractGenerator {

	protected TableInfo tableInfo;
	private static transient Context context;

	protected AbstractGenerator(TableInfo tableInfo) {
		if (null == tableInfo) {
			throw new NullPointerException();
		}
		this.tableInfo = tableInfo;
		context = tableInfo.getContext();
	}

	public static void generateFile(String templateName, String fileName, Map<?, ?> dataMap) {
		GeneratorFileUtil.generateFile(templateName, handleFileName(fileName), dataMap);
	}

	public static void generateFile(TemplateMapperEnum e, String fileName, Map<?, ?> dataMap) {
		GeneratorFileUtil.generateFile(e, handleFileName(fileName), dataMap);
	}
	
	public static void generateFile(TemplateMapperEnum e, String fileName, String fileRelativePath, Map<?, ?> dataMap) {
		GeneratorFileUtil.generateFile(e, fileName, fileRelativePath, dataMap);
	}

	private static String handleFileName(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return null;
		}
		String f = fileName;
		boolean capitalEnable = getGlobalConfig().isSqlMappingFileNameCapital();
		if (capitalEnable) {
			f = StringUtils.capitalLetterToUpperCase(fileName);
		}
		// else {
		// f = StringUtils.capitalLetterToLowerCase(fileName);
		// }
		return f;
	}

	public static GlobalConfiguration getGlobalConfig() {
		return context.getGlobalConfiguration();
	}

	public static PackageData getPackageData() {
		return getGlobalConfig().getPackageData();
	}

	protected String generateProperty(String javaPropertyName, String javaPropertyType, String comment) {
		if (StringUtils.isBlank(javaPropertyName) || StringUtils.isBlank(javaPropertyType)) {
			throw new NullPointerException();
		}
		final StringBuilder props = new StringBuilder();
		props.append("/** ").append(comment).append(" */").append(SymbolConstant.RN)
				.append(JavaVisibility.PRIVATE.getValue()).append(javaPropertyType)
				.append(SymbolConstant.WHITESPACE_CHAR).append(javaPropertyName).append(SymbolConstant.RN);
		return props.toString();
	}

	protected String generateGetterMethod(String javaPropertyName, String javaPropertyType) {
		if (StringUtils.isBlank(javaPropertyName) || StringUtils.isBlank(javaPropertyType)) {
			throw new NullPointerException();
		}
		final StringBuilder getter = new StringBuilder(JavaVisibility.PUBLIC.getValue());
		getter.append(javaPropertyType).append(" get").append(StringUtils.capitalLetterToUpperCase(javaPropertyName))
				.append(SymbolConstant.PARENTHESIS_LEFT).append(SymbolConstant.PARENTHESIS_RIGHT)
				.append(SymbolConstant.BRACE_LEFT).append(SymbolConstant.RN).append("return ").append(javaPropertyName)
				.append(SymbolConstant.SEMICOLON).append(SymbolConstant.R).append(SymbolConstant.BRACE_RIGHT)
				.append(SymbolConstant.RN);
		return getter.toString();
	}

	protected String generateSetterMethod(String javaPropertyName, String javaPropertyType) {
		if (StringUtils.isBlank(javaPropertyName) || StringUtils.isBlank(javaPropertyType)) {
			throw new NullPointerException();
		}
		final StringBuilder setter = new StringBuilder(JavaVisibility.PUBLIC.getValue());
		setter.append("void set").append(StringUtils.capitalLetterToUpperCase(javaPropertyName))
				.append(SymbolConstant.PARENTHESIS_LEFT).append(javaPropertyType).append(SymbolConstant.WHITESPACE_CHAR)
				.append(javaPropertyName).append(SymbolConstant.PARENTHESIS_RIGHT).append(SymbolConstant.BRACE_LEFT)
				.append(SymbolConstant.RN).append("this.").append(javaPropertyName).append(SymbolConstant.EQUAL_SIGN)
				.append(javaPropertyName).append(SymbolConstant.SEMICOLON).append(SymbolConstant.R)
				.append(SymbolConstant.BRACE_RIGHT).append(SymbolConstant.RN);

		return setter.toString();
	}

	protected String generateSetterAndGetterMethod() {
		final StringBuilder s = new StringBuilder();
		List<Column> columns = tableInfo.getColumns();
		for (Column column : columns) {
			String javaPropertyName = column.getJavaPropertyName();
			String javaPropertyType = column.getJavaTypeInfo().getJavaTypeShort();
			s.append(generateSetterMethod(javaPropertyName, javaPropertyType))
					.append(generateGetterMethod(javaPropertyName, javaPropertyType));
		}
		return s.toString();
	}

	public TableInfo getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(TableInfo tableInfo) {
		this.tableInfo = tableInfo;
	}

}
