package ng.bayue.generator.gen;

import java.util.HashMap;
import java.util.Map;

import ng.bayue.generator.constants.GeneratorTemplate;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TableEntityData;

public class FreemarkerGenerator extends AbstractGenerator implements Generator {

	public FreemarkerGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FreemarkerDataModel generate() {
		PackageData pData = context.getGlobalConfiguration().getPackageData();

		FreemarkerDataModel fData = generateModelData(tableInfo);
		fData.setPackageData(pData);
		
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("rootData", fData);
		
		String entityFile = pData.getEntitySavePath() + fData.capitalUpperTableEntityName() + ".java";
		generateFile(GeneratorTemplate.MB_MODEL, entityFile, rootMap);
		
		

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
	
	private static void generateKeyEntity(TableInfo tableInfo, FreemarkerDataModel fData){
		KeyInfoData keyInfoData = tableInfo.getKeyInfo();
	}


}
