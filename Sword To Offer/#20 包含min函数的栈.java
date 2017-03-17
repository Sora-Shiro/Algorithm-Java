/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

import java.util.Stack;

public class Solution {

    private Stack<Integer> s = new Stack<Integer>();
    private static int minNum;
    
    public void push(int node) {
        if(s.empty() || node < minNum){
            s.push(node);
            minNum = node;
        } else {
            s.push(node);
        }
    }
    
    public void pop() {
        if(!s.empty()){
            int popNum = s.pop();
            if(popNum == minNum){
                minNum = findNextMin();
            }
        }
    }
    
    public int top() {
        if(!s.empty()) return s.peek();
        return 0;
    }
    
    public int min() {
        if(!s.empty()) return minNum;
        return 0;
    }
    
    private int findNextMin() {
        if(s.empty()) return 0;
        Stack<Integer> temp = new Stack<Integer>();
        while(!s.empty()){
            temp.push(s.pop());
        }
        int result = temp.pop();
        s.push(result);
        int check;
        while(!temp.empty()){
            check = temp.pop();
            if(check < result) result = check;
            s.push(check);
        }
        return result;
    }
}
