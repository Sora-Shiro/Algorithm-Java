/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */

public class Solution {
    
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int pos = 0;
        int maxJump = 0;
        int nextPos = pos;
        while(nums[pos] != 0) {
            for(int i = 1; i <= nums[pos]; i++) {
                if(pos+i >= nums.length-1) return true;
                if(i + nums[pos + i] > maxJump) {
                    nextPos = pos + i;
                    maxJump = i + nums[pos + i];
                }
            }
            pos = nextPos;
            maxJump = 0;
        }
        return false;
    }
    
}

public class Solution_another {
    
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        for(int i = 0; i < nums.length-1; i++) {
            nums[i] = i+nums[i];
        }
        int pos = 0;
        int maxJump = nums[0];
        int nextPos = pos;
        while(nums[pos] != pos) {
            for(int i = 1; i <= maxJump; i++) {
                if(pos+i >= nums.length-1) return true;
                if(nums[pos+i] >= maxJump) {
                    nextPos = pos + i;
                    maxJump = nums[i];
                }
            }
            pos = nextPos;
            maxJump = 0;
        }
        return false;
    }
    
}

public class Solution_better {
    
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
    
}