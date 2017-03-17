/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

import java.util.*;
public class Solution {
    char[] checkArray = new char[]{
            '(', ')', '{', '}', '[' , ']'
        };
    
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] sa = s.toCharArray();
        
        for(int i = 0; i < sa.length; i++) {
            int offset = getOffset(sa[i]);
            if((offset & 1) == 0){
                stack.add(offset);
            }else{
                if(stack.isEmpty()) return false;
                if(stack.pop() != offset-1) return false;
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
        
    }
    
    private int getOffset(char c) {
        for(int i = 0; i < checkArray.length; i++) {
            if(c == checkArray[i]) return i;
        }
        return -1;
    }
}

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}