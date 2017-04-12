/*
Given a string, you need to reverse the order of characters in each word within a sentence 
while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, 
each word is separated by single space and there will not be any extra space in the string.
 */

public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        char[] ss = s.toCharArray();
        int i = 0, j = 0;
        for(; j < ss.length; ) {
            if(ss[j] != ' ') j++;
            else {
                swap(ss, i, j-1);
                j++;
                i = j;
            }
        }
        if(ss[j-1] != ' ') {
            swap(ss, i, j-1);
        }
        return new String(ss);
    }
    
    private void swap(char[] ss, int i, int j) {
        char temp;
        while(i <= j) {
            temp = ss[i];
            ss[i++] = ss[j];
            ss[j--] = temp;
        }
    }
}