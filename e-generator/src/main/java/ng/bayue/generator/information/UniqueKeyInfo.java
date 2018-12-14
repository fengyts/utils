package ng.bayue.generator.information;

import ng.bayue.generator.constants.ConstraintType;

public class UniqueKeyInfo extends AbstractConstraints {

	public UniqueKeyInfo() {
		super();
		setConstraintType(ConstraintType.UNIQUE.constraintType);
	}

//	@Override
//	public void addColumn(Column... column) {
//		if (null == column) {
//			throw new NullPointerException("unique列不存在");
//		}
//		super.addColumn(column);
//	}

}
