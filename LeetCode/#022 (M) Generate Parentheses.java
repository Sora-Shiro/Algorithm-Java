/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

public class Solution {
    ArrayList<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate(n, new StringBuilder(), 0);
        return result;
    }
    
    private void generate(int remainLeft, StringBuilder s, int needRight) {
        if (needRight != 0) {
            generate(remainLeft, s.append(')'), needRight - 1);
            s.deleteCharAt(s.length()-1);
        }
        if (remainLeft != 0) {
            generate(remainLeft-1, s.append('('), needRight + 1);
            s.deleteCharAt(s.length()-1);
        }
        if(needRight == 0 && remainLeft == 0) {
            result.add(s.toString());
        }
    }
}