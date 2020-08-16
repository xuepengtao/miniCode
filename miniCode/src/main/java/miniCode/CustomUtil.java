package miniCode;

import java.util.regex.Pattern;

public class CustomUtil {

	public static void main(String[] args) {
		byte[] intToBytes = intToBytes(99,2);
		System.out.println("intToBytes: "+intToBytes);
	}

	/**
	 * 是否是0-99的整数
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}?");
        return pattern.matcher(str).matches();
    }
	/**
	 * int 转byte[]
	 * @param a
	 * @param length
	 * @return
	 */
	public static byte[] intToBytes(int a, int length) {
	    byte[] b = new byte[length];
	    for (int i = b.length - 1; i >= 0; i--) {
			b[i] = (byte) (a % 255);
	        a = a / 255;
	    }
	    return b;
	}
}
