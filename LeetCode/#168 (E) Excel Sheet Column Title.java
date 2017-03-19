/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

public class Solution {
    public String convertToTitle(int n) {
	    return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}