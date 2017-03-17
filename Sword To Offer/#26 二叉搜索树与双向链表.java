/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public class Solution {
    int minV;
    TreeNode result;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        minV = pRootOfTree.val;
        result = pRootOfTree;
        if (pRootOfTree.left != null)
            leftToRight(pRootOfTree.left, pRootOfTree, false);
        if (pRootOfTree.right != null)
            leftToRight(pRootOfTree.right, pRootOfTree, true);
        rightToLeft();
        return result;
    }

    private void leftToRight(TreeNode s, TreeNode p, boolean ifRight) {
        if (s.val < minV) {
            minV = s.val;
            result = s;
        }
        if (s.left != null) {
            leftToRight(s.left, min(s, p), ifRight);
            if (ifRight) leftToRight(s.left, max(s, p), ifRight);
        }
        if (s.right != null) {
            leftToRight(s.right, max(s, p), ifRight);
        }
        if (s.right == null) {
            min(s, p).right = max(s, p);
        }
    }

    private void rightToLeft() {
        TreeNode pro = result;
        if (pro != null) 
            TreeNode next = pro.right;
        while (next != null) {
            next.left = pro;
            pro = pro.right;
            next = pro.right;
        }
    }

    private TreeNode min(TreeNode a, TreeNode b) {
        return a.val < b.val ? a : b;
    }

    private TreeNode max(TreeNode a, TreeNode b) {
        return a.val > b.val ? a : b;
    }
}

//直接用中序遍历
public class Solution {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }
     
    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
