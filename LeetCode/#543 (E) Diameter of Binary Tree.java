/*
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
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
    int result = 1;
    
    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return result-1;
    }
    
    private int check(TreeNode root) {
        if(root == null) return 0;
        int lH = check(root.left);
        int rH = check(root.right);
        result = Math.max(result, lH + rH + 1);
        return Math.max(lH, rH) + 1;
    }
}