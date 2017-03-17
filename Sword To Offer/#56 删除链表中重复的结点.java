/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
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