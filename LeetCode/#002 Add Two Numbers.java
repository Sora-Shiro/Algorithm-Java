/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode buff = new ListNode(0);
		ListNode result = buff;
		boolean carry = false;
		boolean bothNull;

		while (true) {
			bothNull = true;
			if (l1 != null) {
				buff.val += l1.val;
				l1 = l1.next;
				bothNull = false;
			}
			if (l2 != null) {
				buff.val += l2.val;
				l2 = l2.next;
				bothNull = false;
			}
			if (bothNull) {
				break;
			}

			if (carry) {
				buff.val++;
			}
			if (buff.val >= 10) {
				carry = true;
				buff.val -= 10;
			} else {
				carry = false;
			}

			if (l1 != null || l2 != null) {
				buff.next = new ListNode(0);
				buff = buff.next;
			}
		}

		if (carry) {
			buff.next = new ListNode(1);
		}

		return result;
	}

/*
Two things to make the code simple:

1. Whenever one of the two ListNode is null, replace it with 0.
2. Keep the while loop going when at least one of the three conditions is met.
 */
	public ListNode addTwoNumbers_better(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == nnull) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = prev.next;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

}