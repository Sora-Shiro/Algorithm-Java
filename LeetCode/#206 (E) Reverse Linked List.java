/*
Reverse a singly linked list.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
	    if(head == null || head.next == null) return head;
	    ListNode result = head;
	    while(result.next != null) result = result.next;
	    head = reverse(head, head.next);
	    head.next = null;
	    return result;
    }
	
	private ListNode reverse(ListNode pre, ListNode cur) {
	    if(cur.next != null) reverse(cur, cur.next);
	    cur.next = pre;
	    return pre;
	}
}

public class Solution_iterative {
    public ListNode reverseList(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}