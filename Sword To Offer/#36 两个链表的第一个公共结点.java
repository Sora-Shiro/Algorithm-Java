/*
输入两个链表，找出它们的第一个公共结点。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1 == null || pHead2 == null) return null;
		ArrayList<ListNode> oneAl = new ArrayList<>();
		ArrayList<ListNode> twoAl = new ArrayList<>();
		while(pHead1 != null) {
			oneAl.add(pHead1);
			pHead1 = pHead1.next;
		}
		while(pHead2 != null) {
			twoAl.add(pHead2);
			pHead2 = pHead2.next;
		}
		Collections.reverse(oneAl);
		Collections.reverse(twoAl);
		int i = 0;
		for(	; 
				i < oneAl.size() && i < twoAl.size() && oneAl.get(i) == twoAl.get(i); 
				i++) ;
		return (i-1>=0) ? oneAl.get(i-1) : null;
    }
}

import java.util.HashMap;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1 == null || pHead2 == null) return null;
		HashMap<ListNode, Integer> map = new HashMap<>();
		while(pHead1 != null) {
			map.put(pHead1, 1);
			pHead1 = pHead1.next;
		}
		while(pHead2 != null) {
			if(map.containsKey(pHead2)) return pHead2;
			pHead2 = pHead2.next;
		}
		return null;
    }
}

import java.util.Stack;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
 
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
 
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
 
        ListNode commonListNode = null;
 
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }
 
        return commonListNode;
    }
}

class Solution {
public:
    ListNode* FindFirstCommonNode( ListNode *pHead1, ListNode *pHead2) {
        ListNode *p1 = pHead1;
        ListNode *p2 = pHead2;
        while(p1!=p2){
            p1 = (p1==NULL ? pHead2 : p1->next);
            p2 = (p2==NULL ? pHead1 : p2->next);
        }
        return p1;
    }
};
