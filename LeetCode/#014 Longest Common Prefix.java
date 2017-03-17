/*
Write a function to find the longest common prefix string amongst an array of strings.
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0)
            return "";

        String save = strs[0];
        int len = save.length();
        int confirm;

        for (int i = 1; i < strs.length; i++) {
            confirm = 0;
            for (int j = 0; j < strs[i].length() && j < save.length()
                    && confirm < len && save.charAt(j) == strs[i].charAt(j); j++) {
                confirm++;
            }
            len = confirm;
        }

        String result = save.substring(0, len);
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
    }
}