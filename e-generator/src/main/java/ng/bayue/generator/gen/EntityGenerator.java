package ng.bayue.generator.gen;

import ng.bayue.generator.information.TableInfo;

public class EntityGenerator extends AbstractGenerator implements Generator {

	public EntityGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@Override
	public <M> M generate() {
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
