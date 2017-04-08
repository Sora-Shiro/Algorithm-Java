/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode step = head;
        int count = 1;
        while(step.next != null) {
            count++;
            step = step.next;
        }
        
        step.next = head;
        
        k = k % count;
        k = count - k;
        
        ListNode last = head;
        while(--k > 0) {
            last = last.next;
        }
        ListNode result = last.next;
        last.next = null;
        
        return result;
    }
}