/*

 */

public class Solution {
	private int len;

	public boolean isPalindrome(int x) {
		String s = x + "";
		len = s.length();
		if (len < 2)
			return true;

		return extendPalindrome(s, s.length() / 2, s.length() / 2)
				|| extendPalindrome(s, s.length() / 2 - 1, s.length() / 2);
	}

	private boolean extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (len == k - j - 1) {
			return true;
		}
		return false;
	}



	public boolean isPalindrome_better(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	    	rev = rev*10 + x%10;
	    	x = x/10;
	    }
	    return (x==rev || x==rev/10);
	}
}

