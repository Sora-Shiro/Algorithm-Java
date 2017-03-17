/*
输入一个链表，反转链表后，输出链表的所有元素。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
    ListNode resultNode;
    
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        Reverse(head, head.next);
        return resultNode;
    }
    
    public void Reverse(ListNode pre, ListNode now) {
        if (now.next != null) {
            Reverse(now, now.next);
        } else {
            resultNode = now;
        }
        pre.next = null;
        now.next = pre;
    }
}


public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

