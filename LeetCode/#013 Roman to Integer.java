/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

public class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> m = new HashMap<>();
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
		int max = 0;
		int result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int value = m.get(s.charAt(i) + "");
			max = max > value ? max : value;
			if(value < max){
				value = -value;
			}
			result += value;
		}
		
		return result;
    }
}