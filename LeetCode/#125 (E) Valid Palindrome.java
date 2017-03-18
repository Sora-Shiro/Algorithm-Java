/*
Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isPalindrome(String s) {
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < s.length(); i++) if(Character.isLetterOrDigit(s.charAt(i))) sb.append(Character.toLowerCase(s.charAt(i)));
	    for(int i = 0, j = sb.length()-1; i <= j; i++, j--) if(sb.charAt(i) != sb.charAt(j)) return false;
        return true;
    }
}