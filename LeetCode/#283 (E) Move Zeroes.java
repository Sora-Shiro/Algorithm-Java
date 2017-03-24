/*
Given an array nums, write a function to move all 0's to the end of it while 
maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
nums should be [1, 3, 12, 0, 0].

Note:
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, notZero = 0;
        while (zero < nums.length && notZero < nums.length) {
            if(nums[notZero] == 0) notZero++;
            else if(nums[zero] != 0) zero++;
            else if(zero >= notZero) notZero++;
            else {
                nums[zero] = nums[notZero];
                nums[notZero] = 0;
                notZero++;
            }
        }
    }
}

public class Solution_better {
    public void moveZeroes(int[] nums) {     
        int insertPos = 0;
        for(int num: nums) if (num != 0) nums[insertPos++] = num;
        while(insertPos < nums.length) nums[insertPos++] = 0;
    }
}