/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        ListNode test = head;
        int len = 0;
        while (test != null) {
            len++;
            test = test.next;
        }
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (; i < len/2; i++) {
            s.push(head.val);
            head = head.next;
        }
        if((len & 1) == 1) {
            head = head.next;
            i++;
        }
        for (; i < len; i++) {
            if(s.pop() != head.val) return false;
            head = head.next;
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}