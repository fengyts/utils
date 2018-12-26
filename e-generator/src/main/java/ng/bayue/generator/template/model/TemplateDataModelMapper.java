package ng.bayue.generator.template.model;

import ng.bayue.generator.constants.GeneratorTemplate;
import ng.bayue.generator.utils.StringUtils;

/**
 * freemarker template 和 PackageData 数据映射器
 * @author lenovopc
 *
 */
public class TemplateDataModelMapper {
	
	private static final String SUFFIX_JAVA = ".java";
	private static final String SUFFIX_XML = ".xml";

	private static transient PackageData packageData;

	public static void init(PackageData packageData){
		TemplateDataModelMapper.packageData = packageData;
	}

	public static enum TemplateMapperEnum {
		// templateName | rootMap-key | savePath | fileName | fileSuffix
		COMMON(GeneratorTemplate.COMMON_G, "commonData", packageData.getCommonSavePath(), "", SUFFIX_JAVA),
		GENERIC_BASIC_MODEL(GeneratorTemplate.GENERIC_BASIC_MODEL, "baseModelData", packageData.getEntitySavePath(), "BaseModel", SUFFIX_JAVA),
		GENERIC_PAGE(GeneratorTemplate.GENERIC_PAGE, "commonData", packageData.getCommonSavePath(), "Page", SUFFIX_JAVA),
		GENERIC_DAO(GeneratorTemplate.GENERIC_DAO, "commonData", packageData.getCommonSavePath(), "GenericDAO", SUFFIX_JAVA),
		GENERIC_SERVICE(GeneratorTemplate.GENERIC_SERVICE, "commonData", packageData.getCommonSavePath(), "GenericService", SUFFIX_JAVA),
		
		GENERIC_DAO_EXCEPTION(GeneratorTemplate.GENERIC_DAO_EXCEPTION, "commonData", packageData.getExceptionSavePath(), "DAOException", SUFFIX_JAVA),
		GENERIC_SERVICE_EXCEPTION(GeneratorTemplate.GENERIC_SERVICE_EXCEPTION, "commonData", packageData.getExceptionSavePath(), "ServiceException", SUFFIX_JAVA),
		
		MB_CONSTANT(GeneratorTemplate.MB_CONSTANT, "commonData", packageData.getConstantSavePath(), "", SUFFIX_JAVA),
		
		MB_KEY(GeneratorTemplate.MB_KEY, "keyInfoData", packageData.getEntitySavePath(), "", SUFFIX_JAVA),
		MB_MODEL(GeneratorTemplate.MB_MODEL, "tableEntityData", packageData.getEntitySavePath(), "", SUFFIX_JAVA),
		MB_DAO(GeneratorTemplate.MB_DAO, "daoData", packageData.getDaoSavePath(), "", SUFFIX_JAVA),
		MB_SQLMAP(GeneratorTemplate.MB_SQLMAP, "sqlMapData", packageData.getSqlMapSavePath(), "", SUFFIX_XML),
		
		MB_DAO_IMPL(GeneratorTemplate.MB_DAO_IMPL, "daoImplData", packageData.getDaoImplSavePath(), "", SUFFIX_JAVA),
		MB_SERVICE(GeneratorTemplate.MB_SERVICE, "serviceData", packageData.getServiceSavePath(), "", SUFFIX_JAVA),
		MB_SERVICE_IMPL(GeneratorTemplate.MB_SERVICE_IMPL, "serviceImplData", packageData.getServiceImplSavePath(), "", SUFFIX_JAVA),
		
		//MB_DAO_UNIQUE(GeneratorTemplate.MB_DAO_UNIQUE, "daoData", packageData.getDaoSavePath(), "", SUFFIX_JAVA),
		//MB_DAO_UNIQUE_IMPL(GeneratorTemplate.MB_DAO_UNIQUE_IMPL, "daoImplData", packageData.getDaoImplSavePath(), "", SUFFIX_JAVA),
		//MB_SERVICE_UNIQUE(GeneratorTemplate.MB_SERVICE_UNIQUE, "serviceData", packageData.getServiceSavePath(), "", SUFFIX_JAVA),
		//MB_SERVICE_UNIQUE_IMPL(GeneratorTemplate.MB_SERVICE_UNIQUE_IMPL, "serviceImplData", packageData.getServiceImplSavePath(), "", SUFFIX_JAVA),
		
		//MB_DAO_BATCH(GeneratorTemplate.MB_DAO_BATCH, "daoData", packageData.getDaoSavePath(), "", SUFFIX_JAVA),
		//MB_DAO_BATCH_IMPL(GeneratorTemplate.MB_DAO_BATCH_IMPL, "daoImplData", packageData.getDaoImplSavePath(), "", SUFFIX_JAVA),
		//MB_SERVICE_BATCH(GeneratorTemplate.MB_SERVICE_BATCH, "serviceData", packageData.getServiceSavePath(), "", SUFFIX_JAVA),
		//MB_SERVICE_BATCH_IMPL(GeneratorTemplate.MB_SERVICE_BATCH_IMPL, "serviceImplData", packageData.getServiceImplSavePath(), "", SUFFIX_JAVA),
		
		
		MB_SQLMAP_CONFIG(GeneratorTemplate.MB_SQLMAP_CONFIG, "sqlMapData", packageData.getSqlMapSavePath(), "", SUFFIX_XML),
		;
		
		private String templateName;
		/** freemarker 模板数据模型key值 */
		private String modelRootMapKey;
		private String savePath;
		private String fileName;
		/** 文件后缀类型 .java | .xml */
		private String fileSuffix;

		private TemplateMapperEnum(String templateName, String modelRootMapKey, String savePath, String fileName,
				String fileSuffix) {
			this.templateName = templateName;
			this.modelRootMapKey = modelRootMapKey;
			this.savePath = savePath;
			this.fileName = fileName;
			this.fileSuffix = fileSuffix;
		}
		
		public String handleFileName(String fileName) {
			String fileFullName = "";
			if (StringUtils.isNotBlank(fileName)) {
				fileFullName = savePath + StringUtils.capitalLetterToUpperCase(fileName) + fileSuffix;
				this.fileName = fileFullName;
			} else {
				fileFullName = savePath + this.fileName + fileSuffix;
			}
			return fileFullName;
		}

		public String getTemplateName() {
			return templateName;
		}

		public void setTemplateName(String templateName) {
			this.templateName = templateName;
		}

		public String getModelRootMapKey() {
			return modelRootMapKey;
		}

		public void setModelRootMapKey(String modelRootMapKey) {
			this.modelRootMapKey = modelRootMapKey;
		}

		public String getSavePath() {
			return savePath;
		}

		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileSuffix() {
			return fileSuffix;
		}

		public void setFileSuffix(String fileSuffix) {
			this.fileSuffix = fileSuffix;
		}

	}

	public PackageData getPackageData() {
		return packageData;
	}

	public void setPackageData(PackageData packageData) {
		TemplateDataModelMapper.packageData = packageData;
	}

}
