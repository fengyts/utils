package ng.bayue.generator.model;

import ng.bayue.generator.constants.ColumnConstraintType;

public class PrimaryKeyInfo extends AbstractConstraints {

	public PrimaryKeyInfo() {
		super();
		setConstraintType(ColumnConstraintType.PRIMAY_KEY.constraintType);
		setConstraintName(ColumnConstraintType.PRIMAY_KEY.constraintName);
	}

//	@Override
//	public void addColumn(Column... column) {
//		if (null == column) {
//			throw new NullPointerException("主键列不存在");
//		}
//		super.addColumn(column);
//	}

}
