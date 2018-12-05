package ng.bayue.generator.model;

import ng.bayue.generator.constants.ColumnConstraintType;

public class UniqueKeyInfo extends AbstractConstraints {

	public UniqueKeyInfo() {
		super();
		setConstraintType(ColumnConstraintType.UNIQUE.constraintType);
	}

//	@Override
//	public void addColumn(Column... column) {
//		if (null == column) {
//			throw new NullPointerException("unique列不存在");
//		}
//		super.addColumn(column);
//	}

}
