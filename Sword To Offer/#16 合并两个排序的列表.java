/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
		if (list2 == null) return list1;
		int a, b;
		ListNode result = new ListNode(0);
		ListNode save = result;
		while (list1 != null && list2 != null) {
			a = list1.val;
			b = list2.val;
			if (a <= b) {
				result.val = a;
				list1 = list1.next;
			} else {
				result.val = b;
				list2 = list2.next;
			}
			result.next = new ListNode(0);
			result = result.next;
		}
		if (list1 == null) {
			while (list2 != null) {
				result.next
			}
		}
		if (list2 == null) {
			while (list1 != null) {
				result.val = list1.val;
				result = result.next;
				list1 = list1.next;
			}
		}
		return save;
    }
}

public class Solution {
	//递归算法
	public ListNode Merge(ListNode list1,ListNode list2) {
       if(list1 == null){
           return list2;
       }
       if(list2 == null){
           return list1;
       }
       if(list1.val <= list2.val){
           list1.next = Merge(list1.next, list2);
           return list1;
       }else{
           list2.next = Merge(list1, list2.next);
           return list2;
       }       
   }

   //非递归算法
   public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;     
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                   mergeHead = current = list1;
                }else{
                   current.next = list1;
                   current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                   mergeHead = current = list2;
                }else{
                   current.next = list2;
                   current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
   }
}

