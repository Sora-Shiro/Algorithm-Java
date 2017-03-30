/*
Given a List of words, return the words that can be typed using letters of alphabet on 
only one row's of American keyboard like the image below.

Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
 */

public class Solution {
    public String[] findWords(String[] words) {
        String up = "qwertyuiop";
        String mid = "asdfghjkl";
        String down = "zxcvbnm";
        ArrayList<String> result = new ArrayList<>();
        for(String word : words){
            int check = 0;
            for(char c : word.toCharArray()) {
                if(up.indexOf(c) != -1) check |= 1;
                if(mid.indexOf(c) != -1) check |= 2;
                if(down.indexOf(c) != -1) check |= 4;
            }
            if(check == 1 || check == 2 || check == 4) result.add(word);
        }
        String[] res = new String[result.size()];
        int i = 0;
        for(String s : result){
            res[i++] = s;
        }
        return res;
    }
}