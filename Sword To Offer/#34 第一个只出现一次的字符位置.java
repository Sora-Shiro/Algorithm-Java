/*
在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */

import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
		char c;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, -1);
			} else {
				map.put(c, i);
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (map.containsValue(i)) {
				return i;
			}
		}
		return -1;
	}
}

public class Solution {
	public int FirstNotRepeatingChar(String str) {
		char[] c = str.toCharArray();
		int[] a = new int['z'];
		for (char d : c)
			a[(int) d]++;
		for (int i = 0; i < c.length; i++)
			if (a[(int) c[i]] == 1)
				return i;
		return -1;
	}
}