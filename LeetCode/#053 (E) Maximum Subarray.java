/*
Find the contiguous subarray within an array 
(containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
		for(int i = 0; i < nums.length; i++) {
			if(sum < 0) sum = nums[i];
			else sum += nums[i];
			if(sum > result) result = sum;
        }
		return result;
    }
}