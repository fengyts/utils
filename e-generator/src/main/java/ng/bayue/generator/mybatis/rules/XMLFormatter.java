package ng.bayue.generator.mybatis.rules;

import ng.bayue.generator.gen.runner.OutputFormatterUtilities;

public class XMLFormatter extends OutputFormatterUtilities {

	// indent level
	/** 根元素，无缩进  */
	private int indentRoot = 0;
	/** sql语句元素, 一个tab键缩进值  */
	private int indentSqlElement = 1;
	private int indentNewLine = 2;
	/** sql语句元素属性, 两个tab键缩进值  */
	private int indentProperty = 2;
	/** sql语句元素子元素, 两个tab键缩进值  */
	private int indentSqlStatement = 2;
	private int indentOther = 3;

	public int getIndentRoot() {
		return indentRoot;
	}

	public void setIndentRoot(int indentRoot) {
		this.indentRoot = indentRoot;
	}

	public int getIndentSqlElement() {
		return indentSqlElement;
	}

	public void setIndentSqlElement(int indentSqlElement) {
		this.indentSqlElement = indentSqlElement;
	}

	public int getIndentNewLine() {
		return indentNewLine;
	}

	public void setIndentNewLine(int indentNewLine) {
		this.indentNewLine = indentNewLine;
	}

	public int getIndentProperty() {
		return indentProperty;
	}

	public void setIndentProperty(int indentProperty) {
		this.indentProperty = indentProperty;
	}

	public int getIndentSqlStatement() {
		return indentSqlStatement;
	}

	public void setIndentSqlStatement(int indentSqlStatement) {
		this.indentSqlStatement = indentSqlStatement;
	}

	public int getIndentOther() {
		return indentOther;
	}

	public void setIndentOther(int indentOther) {
		this.indentOther = indentOther;
	}
	
	

}
