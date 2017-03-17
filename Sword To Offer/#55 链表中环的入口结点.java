/*
一个链表中包含环，请找出该链表的环的入口结点。
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
import java.util.HashSet;
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while(pHead != null) {
            if(set.contains(pHead)) return pHead;
            else set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}