/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        addToNodesList(root, 0);
        Collections.reverse(result);
        return result;
    }
	private void addToNodesList(TreeNode node, int i){
		if(node == null) return;
		if(result.size() < i+1) result.add(new ArrayList<Integer>());
		ArrayList<Integer> nodes = (ArrayList<Integer>) result.get(i);
		nodes.add(node.val);
		addToNodesList(node.left, i+1);
		addToNodesList(node.right, i+1);
	}
}