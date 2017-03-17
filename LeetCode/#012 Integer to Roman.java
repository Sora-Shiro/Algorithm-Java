/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

public class Solution {
    public String intToRoman(int num) {
        String[] ones = new String[] { "", "I", "II", "III", "IV", "V", "VI",
				"VII", "VIII", "IX" };
		String[] tens = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX",
				"LXX", "LXXX", "XC" };
		String[] hunds = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC",
				"DCC", "DCCC", "CM" };
		String[] thous = new String[] { "", "M", "MM", "MMM", "MMMM" };

		String t = thous[num / 1000];
		String h = hunds[num / 100 % 10];
		String te = tens[num / 10 % 10];
		String o = ones[num % 10];

		return t + h + te + o;
    }
}