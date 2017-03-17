/*
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0 
 */

public class Solution {
    public int StrToInt(String str) {
        int sum = 0;
		boolean ifDigit = false;
		boolean ifNeg = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
				sum = 10 * sum + (str.charAt(i) - '0');
				ifDigit = true;
			} else if (str.charAt(i) == '-') {
				if (ifDigit) return 0;
				ifNeg = true;
			} else if (str.charAt(i) != '+') {
				return 0;
			}
		}
		if (ifNeg) sum = -sum;
		return sum;
    }
}