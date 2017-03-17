/*
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode pHead) {
		ListNode newHead = new ListNode(0);
		newHead.next = pHead;
		ListNode pre = newHead;
		ListNode now = pHead;
		ListNode after = null;
		while(now != null) {
			after = now.next;
			if(after != null && now.val == after.val) {
				pre.next = after.next;
				while(pre.next != null && pre.next.val == now.val) {
					pre.next = pre.next.next;
				}
				now = pre.next;
			} else {
				pre = pre.next;
				now = pre.next;
			}
		}
		return newHead.next;
    }
}