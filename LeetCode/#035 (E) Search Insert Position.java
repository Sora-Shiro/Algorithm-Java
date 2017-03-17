/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length/2, nums.length-1, target);
    }
	
	private int binarySearch(int[] nums, int left, int mid, int right, int target){
		if(left > right) return target > nums[mid] ? mid + 1 : mid;
		if(target > nums[mid]) return binarySearch(nums, mid + 1, (mid + right + 1) / 2, right, target);
		else if(target < nums[mid]) return binarySearch(nums, left, (left + mid) / 2, mid - 1, target);
		else return mid;
	}
}

public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}