/*
输入一个链表，输出该链表中倒数第k个结点。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.Stack;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		Stack<ListNode> s = new Stack<ListNode>();
		int num = 0;
		while (head != null) {
			num++;
			s.push(head);
			head = head.next;
		}
		if (s.empty() || k > num || k <= 0) return null;
		while (--k != 0) {
			s.pop();
		}

		return s.pop();
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode pre=head;
        ListNode last=head;       
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}