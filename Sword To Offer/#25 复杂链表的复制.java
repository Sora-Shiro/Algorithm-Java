/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode result = new RandomListNode(pHead.label);
        RandomListNode resultHead = result;
        while (pHead != null) {
            if(pHead.next != null) result.next = new RandomListNode(pHead.next.label);
            if(pHead.random != null) result.random = new RandomListNode(pHead.random.label);
            result = result.next;
            pHead = pHead.next;
        }
        return resultHead;
    }
}