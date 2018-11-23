package ng.bayue.generator.constants;

public enum ColumnConstraintType {

	INDEX("INDEX"), // 索引
	PRIMAY_KEY("PRIMARY KEY"), // 主键
	UNIQUE("UNIQUE"), // 唯一索引
	FOREIGN_KEY("FOREIGN KEY"), // 外键
	/** 检查约束,检查--enum、set;
	 * MySQL可以使用check约束，但check约束对数据验证没有任何作用。
	 * Oracle中可以使用check约束，是有相应的作用的。 
	 */
	CHECK("Check"), // 检查约束,检查--enum、set;
	DEFAULT("Default"), // 默认值
	NOT_NULL("NOT NULL"); // 非空约束

	public String typeName;

	private ColumnConstraintType(String typeName) {
		this.typeName = typeName;
	}

}
