/*
Given an integer array, you need to find one continuous subarray that 
if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

 */

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1;
        int end = -2;
        int max = nums[0], min = nums[n-1];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n-1-i], min);
            if(max > nums[i]) {
                end = i;
            }
            if(min < nums[n-1-i]) {
                begin = n-1-i;
            }
        }
        return end - begin + 1;
    }
}