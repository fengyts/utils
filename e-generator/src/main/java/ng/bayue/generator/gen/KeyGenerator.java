package ng.bayue.generator.gen;

import java.util.ArrayList;
import java.util.List;

import ng.bayue.generator.gen.model.Parameter;
import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.PrimaryKeyInfo;
import ng.bayue.generator.information.TableInfo;

public class KeyGenerator extends AbstractGenerator implements Generator {

	public KeyGenerator(TableInfo tableInfo) {
		super(tableInfo);
	}

	@Override
	public <M> M generate() {
		return null;
	}

	private void generatePrimaryKey() {
		PrimaryKeyInfo pkInfo = tableInfo.getConstraintsInfo().getPkInfo();
		List<Column> columns = pkInfo.getColumns();
		if (null == columns || columns.size() == 0) {
			throw new NullPointerException("primary key get failure");
		}
		boolean isUnion = pkInfo.isUnionKey();
		String pkClassName = "";
		if (isUnion) {
			pkClassName = tableInfo.getHumpFormat() + "PrimaryKey";
			List<Parameter> parameters = new ArrayList<Parameter>();
			Parameter param = new Parameter();
		} else {
			Column column = columns.get(0);
			pkClassName = column.getJavaPropertyType();
		}
	}

}
