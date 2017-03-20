/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode newResult = newHead;
        newHead.next = head;
        while (head != null) {
            if (head.val == val)  newHead.next = head.next;
            else  newHead = newHead.next;
            head = head.next; 
        }
        return newResult.next;
    }
}

public class Solution_noExtraHead {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }
}

public class Solution_amazing {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head;
    }
}