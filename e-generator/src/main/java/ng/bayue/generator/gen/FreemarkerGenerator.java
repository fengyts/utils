package ng.bayue.generator.gen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.ConstraintsInfo;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.template.model.KeyInfoData.KeyInfo;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TableEntityData;
import ng.bayue.generator.template.model.TemplateDataModelMapper.TemplateMapperEnum;

public class FreemarkerGenerator extends AbstractGenerator implements Generator {

	public FreemarkerGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FreemarkerDataModel generate() {
		PackageData pData = getPackageData();

		FreemarkerDataModel fData = generateModelData(tableInfo);
		fData.setPackageData(pData);

		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("rootData", fData);

		TemplateMapperEnum basicModelMapper = TemplateMapperEnum.GENERIC_BASIC_MODEL;

		final String commonPackageName = pData.getCommonPackageName();
		final String baseModelPackageName = pData.getEntityPackageName();
		final String baseModelName = basicModelMapper.getFileName();
		rootMap.put("commonPackageName", commonPackageName);
		rootMap.put("baseModelPackageName", baseModelPackageName);
		rootMap.put("baseModelName", baseModelName);
		
		List<Column> allColumns = tableInfo.getColumns();
		ConstraintsInfo constraintsInfo = tableInfo.getConstraintsInfo();
		List<Column> pks = constraintsInfo.getPkInfo().getColumns();

		rootMap.put("allColumns", allColumns);
		rootMap.put("pkColumns", pks);
		rootMap.put("pkColumnSize", pks == null ? 0 : pks.size());

		// 生成通用工具类
		generateFile(basicModelMapper, null, rootMap);
		generateFile(TemplateMapperEnum.GENERIC_PAGE, null, rootMap);
		generateFile(TemplateMapperEnum.GENERIC_DAO_EXCEPTION, null, rootMap);
		generateFile(TemplateMapperEnum.GENERIC_SERVICE_EXCEPTION, null, rootMap);
		generateFile(TemplateMapperEnum.GENERIC_DAO, null, rootMap);
		// generateFile(TemplateMapperEnum.GENERIC_SERVICE, null, rootMap);
		generateFile(TemplateMapperEnum.GENERIC_DAO_IMPL_BASIC, null, rootMap);
		
		// 生成主键和唯一键
		generateKeyEntity(tableInfo, TemplateMapperEnum.MB_KEY, rootMap);
		// 生成实体类
		String tableNameHumpFormat = tableInfo.getHumpFormat();
		generateFile(TemplateMapperEnum.MB_MODEL, tableNameHumpFormat, rootMap);
		// 生成dao
		generateFile(TemplateMapperEnum.MB_DAO, tableNameHumpFormat + "DAO", rootMap);
		// 生成dao接口实现类
		generateFile(TemplateMapperEnum.MB_DAO_IMPL, tableNameHumpFormat + "MybatisDAO", rootMap);
		// 生成sql mapper xml
		// generateFile(TemplateMapperEnum.MB_SQLMAP,tableNameHumpFormat,rootMap);
		generateSqlMap(tableInfo, rootMap);

		boolean generateServiceEnable = getGlobalConfig().isServiceEnable();
		if (generateServiceEnable) {
			generateFile(TemplateMapperEnum.GENERIC_SERVICE, null, rootMap);
			generateFile(TemplateMapperEnum.MB_SERVICE, tableNameHumpFormat + "Service", rootMap);
			generateFile(TemplateMapperEnum.MB_SERVICE_IMPL, tableNameHumpFormat + "ServiceImpl", rootMap);
		}
		
//		generateFile(TemplateMapperEnum.MB_SERVICE_UNIQUE, "testGenerateFileUtil", "extends", rootMap);

		return fData;
	}

	private static FreemarkerDataModel generateModelData(TableInfo tableInfo) {
		FreemarkerDataModel fData = new FreemarkerDataModel();

		TableEntityData tableData = new TableEntityData();
		tableData.setTableName(tableInfo.getTableName());
		tableData.setTableEntityName(tableInfo.getHumpFormat());
		tableData.setAllColumns(tableInfo.getColumnStr());
		tableData.setProperties(tableInfo.getEntityProperties());
		tableData.setImports(tableInfo.getImports());

		fData.setTableEngityData(tableData);
		return fData;
	}

	private static void generateKeyEntity(final TableInfo tableInfo, TemplateMapperEnum mapper,
			Map<String, Object> rootMap) {
		KeyInfoData keyInfoData = tableInfo.getKeyInfo();
		KeyInfo primaryKey = keyInfoData.getPrimaryKey();
		rootMap.put("primaryKeyInfoData", primaryKey);
		if (keyInfoData.isUnionPK()) {
			rootMap.put(mapper.getModelRootMapKey(), primaryKey);
			generateFile(mapper, primaryKey.getKeyClassSimpleName(), rootMap);
		}
		boolean unionUniqueModelEnable = tableInfo.getTableConfiguration().isUnionUniqueModelEnable();
		if (unionUniqueModelEnable && keyInfoData.isHasUniqueKey()) {
			List<KeyInfo> ukInfos = keyInfoData.getUniqueKey();
			for (KeyInfo keyInfo : ukInfos) {
				if (keyInfo.getIsUnion()) {
					rootMap.put(mapper.getModelRootMapKey(), keyInfo);
					generateFile(mapper, keyInfo.getKeyClassSimpleName(), rootMap);
				}
			}
		}
	}

	private static void generateSqlMap(final TableInfo tableInfo, Map<String, Object> rootMap) {
//		List<Column> allColumns = tableInfo.getColumns();
//		ConstraintsInfo constraintsInfo = tableInfo.getConstraintsInfo();
//		List<Column> pks = constraintsInfo.getPkInfo().getColumns();
//
//		rootMap.put("allColumns", allColumns);
//		rootMap.put("pkColumns", pks);
//		rootMap.put("pkColumnSize", pks == null ? 0 : pks.size());

		generateFile(TemplateMapperEnum.MB_SQLMAP, tableInfo.getHumpFormat(), rootMap);
	}

}
