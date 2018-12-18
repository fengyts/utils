package ng.bayue.generator.information;

import ng.bayue.generator.constants.ConstraintType;

public class PrimaryKeyInfo extends AbstractConstraints {

	public PrimaryKeyInfo() {
		super();
		setConstraintType(ConstraintType.PRIMAY_KEY.constraintType);
		setConstraintName(ConstraintType.PRIMAY_KEY.constraintName);
	}

	@Override
	public boolean isUnionKey() {
		return super.isUnionKey();
	}

//	@Override
//	public void addColumn(Column... column) {
//		if (null == column) {
//			throw new NullPointerException("主键列不存在");
//		}
//		super.addColumn(column);
//	}
	
	

}
