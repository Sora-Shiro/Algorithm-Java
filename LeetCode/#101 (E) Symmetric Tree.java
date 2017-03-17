/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode pRoot) {
        if (pRoot == null) return true;
        return f(pRoot.left,pRoot.right);
    }
    private boolean f(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) 
            return true;
        if (t1 != null && t2 != null) 
            return t1.val == t2.val && f(t1.left,t2.right) && f(t1.right, t2.left);
        return false;
    }
}