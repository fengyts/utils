package ng.bayue.test;

import java.util.Random;

public class LettersAndNumberUtil {

	private static final char[] numbers_char = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private static final int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private static final char[] letters = { 
			'a', 'b', 'c', 'd', 'e', 'f', 
			'g', 'h', 'i', 'j', 'k', 'l', 
			'm', 'n', 'o', 'p', 'q', 'r', 
			's', 't', 'u', 'v', 'w', 'x', 
			'y', 'z' 
	};
	private static final char[] letters_capital = {
			'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 
			'M', 'N', 'O', 'P', 'Q', 'R', 
			'S', 'T', 'U', 'V', 'W', 'X', 
			'Y', 'Z' 
	};
	
	private static final int TYPE_NUMBER = 0;
	
	private static final int TYPE_LETTER = 1;
	
	private static final int TYPE_ALL = 2;

	private static char[] initAllChar() {
		final char[] allChars = new char[62];
		System.arraycopy(letters, 0, allChars, 0, letters.length);
		System.arraycopy(letters_capital, 0, allChars, 26, letters_capital.length);
		System.arraycopy(numbers_char, 0, allChars, 52, numbers_char.length);
		// System.out.println(Arrays.toString(allChars));
		return allChars;
	}

	private static char[] initAllChar1() {
		final char[] allChars = new char[62];
		int len = 0;
		for (int i = 97; i <= 122; i++) {
			allChars[len++] = (char) i;
		}
		for (int i = 65; i <= 90; i++) {
			allChars[len++] = (char) i;
		}
		for (int i = 48; i <= 57; i++) {
			allChars[len++] = (char) i;
		}
//		System.out.println(Arrays.toString(allChars));
		return allChars;
	}
	
	/**
	 * @param len
	 * @param type  1: only number of 0~9; 
	 * 				2: only lowercase letters;
	 * 				3: only uppercase letters;
	 * 				4: only number and lowercase letters; 
	 * 				5: only number and uppercase letters; 
	 * 				6: only lowercase and uppercase letters; 
	 * 				7: all letters
	 * @return
	 */
	public static String randomStr(int len, int type) {
		String rs = "";
		switch (type) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			rs = getRandomStr(len);
			break;
		default:
			break;
		}
		return rs;
	}
	
	public static String getRandomStr(int len) {
		Random rd = new Random();
		char[] chars = initAllChar();
		StringBuilder rs = new StringBuilder();
		for (int i = 0; i < len; i++) {
			rs.append(chars[rd.nextInt(62)]);
		}
		return rs.toString();
	}
	
	public static void main(String[] args) {
		// initAllChar();
		System.out.println(randomStr(10, 7));
	}

}
