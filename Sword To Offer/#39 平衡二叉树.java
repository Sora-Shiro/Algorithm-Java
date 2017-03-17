/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class Solution {
    int maxDepth = 0;
	int aMaxDepth = Integer.MAX_VALUE;
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root != null){
        	if(root.left != null) findNext(root.left, 1);
			else aMaxDepth = 1;
        	if(root.right != null) findNext(root.right, 1);
        	else aMaxDepth = 1;
        } else {
        	return true;
        }
		return maxDepth - aMaxDepth <= 1;
    }
	
	private void findNext(TreeNode root, int depth){
		depth++;
		if(root.left != null) findNext(root.left, depth);
		if(root.right != null) findNext(root.right, depth);
		if(root.left == null && root.right == null){
			if(depth > maxDepth) maxDepth = depth;
			if(depth < aMaxDepth) aMaxDepth = depth;
		}
	}
}