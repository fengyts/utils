package ng.bayue.generator.gen;

import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.TableEntityData;

public class EntityGenerator extends AbstractGenerator implements Generator {

	public EntityGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@Override
	public <M> M generate() {
		TableEntityData data = new TableEntityData();
		data.setAllColumns(tableInfo.getColumnStr());
		data.setTableName(tableInfo.getTableName());
		data.setTableEntityName(tableInfo.getHumpFormat());
		return null;
	}

	public String generateGetterMethod(String javaPropertyName, String javaPropertyType) {
		return super.generateGetterMethod(javaPropertyName, javaPropertyType);
	}

	public String generateSetterMethod(String javaPropertyName, String javaPropertyType) {
		return super.generateSetterMethod(javaPropertyName, javaPropertyType);
	}

	public String generateSetterAndGetterMethod() {
		return super.generateSetterAndGetterMethod();
	}

}
