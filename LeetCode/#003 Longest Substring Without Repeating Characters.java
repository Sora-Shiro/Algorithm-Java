/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int size = s.length();
		LinkedList<String> result = new LinkedList<String>();
    	int resultNum = 0;
        for (int i = 0; i < size; i++) {
       		while (result.contains(s.charAt(i)+"")) {
       			resultNum = result.size() > resultNum ? result.size() : resultNum ;
       			result.remove(result.get(0)+"");
       		}
       		result.add(s.charAt(i)+"");
        }
        resultNum = result.size() > resultNum ? result.size() : resultNum ;
        return resultNum;
    }

	public int lengthOfLongestSubstring_new(String s) {
    	int size = s.length();
		String result = new String();
    	int resultNum = 0;
        for (int i = 0; i < size; i++) {
       		if (result.contains(s.charAt(i)+"")) {
       			resultNum = result.length() > resultNum ? result.length() : resultNum ;
       			result = result.substring(result.indexOf(s.charAt(i)) + 1);
       		}
       		result = result + s.charAt(i);
        }
        resultNum = result.length() > resultNum ? result.length() : resultNum ;
        return resultNum;
    }

    public int lengthOfLongestSubstring_better(String s) {
    	if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
    
}