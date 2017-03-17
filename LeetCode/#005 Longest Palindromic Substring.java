/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

public class Solution {
    public String longestPalindrome(String s) {
        char mid;
		int repair = 0;
		boolean check;
		String buff = "";
		buff += s.charAt(0);
		String result = s.charAt(0) + "";
		String l;

		for (int i = 1; i < s.length(); i++) {
			l = "";
			check = false;
			int lenBuff = buff.length();
			if (buff.charAt(lenBuff - 1) == s.charAt(i)) {
				mid = buff.charAt(lenBuff - 1);
				repair = 1;
				check = true;
			}
			if (check) {
				mid = buff.charAt(lenBuff - 1);
				for (int x = 1; (lenBuff - 1) - x + repair >= 0
						&& (lenBuff - 1) + x < s.length(); x++) {
					if (buff.charAt(lenBuff - 1 - x + repair) == s
							.charAt(lenBuff - 1 + x)) {
						String save = buff.charAt(lenBuff - 1 - x + repair) + "";
						save += l;
						save += buff.charAt(lenBuff - 1 - x + repair) + "";
						l = save;
					} else {
						break;
					}
				}
				if (result.length() < l.length()) {
					result = l;
				}
			}

			l = "";
			check = false;
			if (buff.length() > 1 && buff.charAt(lenBuff - 2) == s.charAt(i)) {
				mid = buff.charAt(lenBuff - 1);
				l += mid;
				repair = 0;
				check = true;
			}
			if (check) {
				mid = buff.charAt(lenBuff - 1);
				for (int x = 1; (lenBuff - 1) - x + repair >= 0
						&& (lenBuff - 1) + x < s.length(); x++) {
					if (buff.charAt(lenBuff - 1 - x + repair) == s
							.charAt(lenBuff - 1 + x)) {
						String save = buff.charAt(lenBuff - 1 - x + repair) + "";
						save += l;
						save += buff.charAt(lenBuff - 1 - x + repair) + "";
						l = save;
					} else {
						break;
					}
				}
				if (result.length() < l.length()) {
					result = l;
				}
			}

			buff += s.charAt(i);
		}

		return result;
    }
}

public class Solution_better {
	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}