/*
Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and 
its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();
        if (len % 1 == 1) {
            for (int i = 0; i < len; i++) {
                if(ss[i] != ss[0]) return false;
            }
            return true;
        }
        int half = len / 2;
        for(int i = 0; i < half; i++){
            if(len % (i+1) != 0) continue;
            int j = i+1;
            for(; j < len; j++){
                if(ss[j] != ss[j%(i+1)]) break;
            }
            if(j == len) return true;
        }
        return false;
    }
}