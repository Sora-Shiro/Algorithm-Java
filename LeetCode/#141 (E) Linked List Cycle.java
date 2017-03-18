/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
	    ListNode i = head;
	    ListNode j = head;
	    while(j != null && j.next != null) {
	        j = j.next.next;
	        if(i == j) return true;
	        i = i.next;
	    }
	    return false;
    }
}