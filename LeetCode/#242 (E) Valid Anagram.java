/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] save = new int[26];
        for (char c : ss) {
            save[c-'a']++;
        }
        for (char c : ts) {
            if(save[c-'a'] > 0) save[c-'a']--;
            else return false;
        }
        return true;
    }
}

public class Solution_unicode {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (char i : ss) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        for (char i : ts) {
            if(map.containsKey(i) && map.get(i) > 0) map.put(i, map.get(i)-1);
            else return false;
        }
        return true;
    }
}

public class Solution_unicode_nomap {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] save = new int[1114112];
        for (char c : ss) {
            save[c]++;
        }
        for (char c : ts) {
            if(save[c] > 0) save[c]--;
            else return false;
        }
        return true;
    }
}