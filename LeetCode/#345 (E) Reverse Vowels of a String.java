/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */

public class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] array = s.toCharArray();
        while (i < j) {
            if(!checkVowels(array[i])) i++;
            else if(!checkVowels(array[j])) j--;
            else {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return new String(array);
    }
    
    private boolean checkVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}