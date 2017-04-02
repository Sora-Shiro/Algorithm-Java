/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode savePre = pre;
        ListNode l = head;
        ListNode r = head.next;
        boolean reverse = false;
        while(l != null && r != null){
            if(reverse){
                swap(r, l);
                pre.next = l;
            } else {
                swap(l, r);
                pre.next = r;
            }
            if(l.next != null){
                l = l.next.next;
            }
            if(r.next != null){
                r = r.next.next;
            }
            pre = pre.next.next;
            reverse = !reverse;
        }
        return savePre.next;
    }
    
    private void swap(ListNode l, ListNode r) {
        l.next = r.next;
        r.next = l;
    }
}

public class Solution_better {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return dummy.next;
    }
}