/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
		return findNextInsert(nums, 0, nums.length - 1, null);
    }

	private TreeNode findNextInsert(int[] nums, int left, int right, TreeNode node) {
		if(left > right) return null;
		int mid = (left+right) / 2;
		node = new TreeNode(nums[mid]);
		node.left = findNextInsert(nums, left, mid-1, node.left);
		node.right = findNextInsert(nums, mid+1, right, node.right);
		return node;
	}
}