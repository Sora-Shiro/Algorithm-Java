/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order. 
 */

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1) set.add(i);
        HashSet<Integer> result = new HashSet<>();
        for(int i : nums2) if(set.contains(i)) result.add(i);
        int[] last = new int[result.size()];
        int j = 0;
        for(int i : result) last[j++] = i;
        return last;
    }
}