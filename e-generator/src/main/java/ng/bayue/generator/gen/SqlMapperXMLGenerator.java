package ng.bayue.generator.gen;

import java.util.List;

import ng.bayue.generator.constants.SymbolConstant;
import ng.bayue.generator.constants.XMLConstants;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.SqlMapperXMLData;

public class SqlMapperXMLGenerator extends AbstractGenerator implements Generator {

	// private static final String XML_MAPPER_HEADER = getXMLMapperHeader();
	/** 
	 * <?xml version=\"1.0\" encoding=\"UTF-8\" ?>
	 * <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	 * "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	 */
	public static final StringBuilder getXMLMapperHeader() {
		final StringBuilder header = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		header.append("\r\n<!DOCTYPE mapper PUBLIC \"").append(XMLConstants.MYBATIS3_MAPPER_PUBLIC_ID)
				.append(SymbolConstant.DOUBLE_QUOTES).append(SymbolConstant.WHITESPACE_CHAR)
				.append(SymbolConstant.DOUBLE_QUOTES).append(XMLConstants.MYBATIS3_MAPPER_SYSTEM_ID)
				.append(SymbolConstant.DOUBLE_QUOTES).append(SymbolConstant.ANGLE_BRACKET_RIGHT);
		return header;
	}

	public SqlMapperXMLGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	public static void main(String[] args) {
		SqlMapperXMLGenerator g = new SqlMapperXMLGenerator(null);
		String xmlMapper = g.generate();
		System.out.println(xmlMapper);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M> M generate() {
		final SqlMapperXMLData xmlMapper = new SqlMapperXMLData();
		xmlMapper.setNameSpace("");

		xmlMapper.setBaseAllColumns(generateAllColumns());
		xmlMapper.setBaseResultMap(generateXMLBaseResultMapSql());
		xmlMapper.setWhereSql(generateWhereSql());

		xmlMapper.setInsertSql(generateInsertSql());
		xmlMapper.setSelectByPrimaryKeySql(generateSelectByPrimaryKeySql());
		xmlMapper.setSelectDynamicSql(generateSelectDynamicSql());
		xmlMapper.setUpdateAllColumnByPrimaryKeySql(generateUpdateByPrimaryKeySql());
		xmlMapper.setUpdateDynamicSql(generateUpdateDynamicSql());
		xmlMapper.setDeletePhysicalSql(generateDeletePhysicalSql());

		xmlMapper.setSelectByUniqueSqls(generateSelectByUniqueSql());
		xmlMapper.setUpdateDynamicByUniqueSqls(generateUpdateByUniqueSql());

		xmlMapper.setBatchInsertSql(generateBatchInsert());
		xmlMapper.setBatchSelectByPrimaryKeySql(generateBatchSelectByPrimaryKeySql());
		xmlMapper.setBatchUpdateByPrimaryKeySql(generateBatchUpdateByPrimaryKeySql());
		xmlMapper.setBatchDeleteByPrimaryKeySql(generateBatchDeleteByPrimaryKeySql());

		return (M) xmlMapper;
	}

	private static final String BASE_RESULTMAP_ID = "\"BaseResultMap\"";
	private static final String ID_PROPERTIE = " id=";
	private static final String PARAMETER_PROPERTIE = " parameterType=";
	private static final String RESULTTYPE_PROPERTIE = " resultType=";

	private String generateXMLBaseResultMapSql() {
		StringBuilder sql = new StringBuilder();
		// <resultMap type="${complete_package_class_name}" id="${resultMap}">
		sql.append("<resultMap type=\"").append(tableInfo.getHumpFormat()).append(SymbolConstant.DOUBLE_QUOTES)
				.append(ID_PROPERTIE).append(BASE_RESULTMAP_ID).append(SymbolConstant.ANGLE_BRACKET_RIGHT);
		return sql.toString();
	}

	private String generateAllColumns() {
		return tableInfo.getColumnStr();
	}

	private String generateWhereSql() {
		return null;
	}

	private String generateInsertSql() {
		return "";
	}

	private String generateSelectByPrimaryKeySql() {
		return "";
	}

	private String generateSelectDynamicSql() {
		return "";
	}

	private String generateUpdateByPrimaryKeySql() {
		return "";
	}

	private String generateUpdateDynamicSql() {
		return "";
	}

	private String generateDeletePhysicalSql() {
		return "";
	}

	private List<String> generateSelectByUniqueSql() {
		return null;
	}

	private List<String> generateUpdateByUniqueSql() {
		return null;
	}

	private String generateBatchInsert() {
		return null;
	}

	private String generateBatchSelectByPrimaryKeySql() {
		return null;
	}

	private String generateBatchDeleteByPrimaryKeySql() {
		return null;
	}

	private String generateBatchUpdateByPrimaryKeySql() {
		return null;
	}

}
