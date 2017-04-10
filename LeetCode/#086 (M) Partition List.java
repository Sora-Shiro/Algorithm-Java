/*
Given a linked list and a value x, partition it such that 
all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode checkHead = fakeHead;
        while(checkHead.next != null && checkHead.next.val < x) checkHead = checkHead.next;
        if(checkHead == null || checkHead.next == null) return head;
        ListNode checkPre = checkHead.next;
        ListNode check = checkPre.next;
        while(check != null) {
            if(check.val < x) {
                checkPre.next = check.next;
                check.next = checkHead.next;
                checkHead.next = check;
                check = checkPre.next;
                
                checkHead = checkHead.next;
            } else {
                checkPre = checkPre.next;
                check = check.next;
            }
        }
        return fakeHead.next;
    }
}

public class Solution_better {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  
        ListNode curr1 = dummy1, curr2 = dummy2;     
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}