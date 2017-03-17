/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0) return false;
		if (sequence.length == 1) return true;

		return check(sequence, 0, sequence.length - 1);
	}

	private boolean check(int[] nums, int start, int end) {
		if (start >= end) return true;
		int mid = end - 1;
		
		// 从后往前
		while (mid >= start && nums[mid--] > nums[end]) {
			;
		}
		// 从前往mid
		for (int mustSmaller = start; mustSmaller <= mid; mustSmaller++) {
			if (nums[mustSmaller] > nums[end]) {
				return false;
			}
		}
		
		return check(nums, start, mid) && check(nums, mid + 1, end - 1);
	}
}