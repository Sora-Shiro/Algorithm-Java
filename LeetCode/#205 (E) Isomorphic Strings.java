/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while 
preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] dict = new char[128];
        boolean[] record = new boolean[128];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        char cS;
        char cT;
        for(int i = 0; i < ss.length; i++){
            cS = ss[i];
            cT = ts[i];
            if(dict[cS] == 0 && record[cT] == false) {
                dict[cS] = cT;
                record[cT] = true;
            }
            else if(dict[cS] != cT) return false;
        }
        return true;
    }
}

public class Solution_slower {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}