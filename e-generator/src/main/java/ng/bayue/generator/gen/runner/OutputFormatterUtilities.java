package ng.bayue.generator.gen.runner;

import ng.bayue.generator.constants.SymbolConstant;

public class OutputFormatterUtilities {

	private static final String line_Separator;
	protected static final int STEP = 2;
	/** 
	 * 1: 按照SymbolConstant.WHITESPACE_CHAR_TAB缩进；
	 * 2.按照SymbolConstant.WHITESPACE_CHAR_DOUBLE缩进, 按照此方式缩进indentLevel将翻倍
	 */
	private static final int INDENT_TYPE = 1;
	private static int newLineCharNum = 80;

	static {
		String ls = System.getProperty("line.separator");
		if (ls == null) {
			ls = SymbolConstant.N;
		}
		line_Separator = ls;
	}

	public static void indent(StringBuilder s, int indentLevel) {
		indent(s, indentLevel, INDENT_TYPE);
	}

	public static void indent(StringBuilder s, int indentLevel, Integer indentTypeC) {
		if (null == indentTypeC || indentTypeC.intValue() == INDENT_TYPE) {
			for (int i = 0; i < indentLevel; i++) {
				s.insert(0, SymbolConstant.WHITESPACE_CHAR_TAB);
			}
		} else {
			indentLevel *= indentLevel;
			for (int i = 0; i < indentLevel; i++) {
				s.insert(0, SymbolConstant.WHITESPACE_CHAR_DOUBLE);
			}
		}

	}

	public static void newLine(StringBuilder s) {
		s.append(line_Separator);
	}

	public static void newLineIndent(StringBuilder s, int indentLevel, CharSequence cs) {
		StringBuilder is = new StringBuilder(cs);
		indent(is, indentLevel);
		s.append(is);
	}

	public static int getNewLineCharNum() {
		return newLineCharNum;
	}

	public static void setNewLineCharNum(int newLineCharNum) {
		OutputFormatterUtilities.newLineCharNum = newLineCharNum;
	}

}
