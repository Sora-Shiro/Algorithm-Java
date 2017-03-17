/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int part;
        while (!stack1.isEmpty()) {
            part = stack1.pop();
            stack2.push(part);
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            part = stack2.pop();
            stack1.push(part);
        }
        return result;
    }
}

//下面这个方法没有把栈2的数据重新压回栈1，而是检测栈2是否为空
//如果不为空则弹出一个，从为空的时候取得的所有栈1的数据

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
     
    public void push(int node) {
        stack1.push(node);
    }
     
    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}