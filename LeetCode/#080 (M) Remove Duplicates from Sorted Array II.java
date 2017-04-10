/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 1;
        int cur = nums[0];
        int record = 1;
        for(int i = 1; i < nums.length; i++) {
            if(cur == nums[i]) {
                count++;
            } else {
                count = 1;
                cur = nums[i];
            }
            if(count <= 2) {
                nums[record++] = nums[i];
            }
        }
        return record;
    }
}

public class Solution_better {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}