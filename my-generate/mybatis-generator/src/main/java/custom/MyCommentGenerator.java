package custom;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;

public class MyCommentGenerator extends AbstractCommentGenerator {

	public MyCommentGenerator() {
		super();
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		if (defaultComments) {
			defaultComment(field, introspectedTable, introspectedColumn);
		} else {
			field.addJavaDocLine("/** " + introspectedColumn.getRemarks() + " */");
		}

	}

	private void defaultComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		field.addJavaDocLine("/**");
		field.addJavaDocLine(" * ");
		field.addJavaDocLine(" * This field was generated by MyBatis Generator.");
		field.addJavaDocLine(" * This field corresponds to the database column "
				+ introspectedTable.getTableConfiguration().getTableName() + "."
				+ introspectedColumn.getActualColumnName());
		field.addJavaDocLine(" * ");
		field.addJavaDocLine(" * @mbg.generated ");
		field.addJavaDocLine(" */");
	}

}