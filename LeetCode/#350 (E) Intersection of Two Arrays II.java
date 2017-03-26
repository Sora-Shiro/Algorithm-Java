/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?
 */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int num : nums1) {
            if(!map1.containsKey(num)) map1.put(num, 0);
            map1.put(num, map1.get(num)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(map1.containsKey(num)) {
                list.add(num);
                map1.put(num, map1.get(num)-1);
                if(map1.get(num) == 0) map1.remove(num);
            }
        }
        int[] result = new int[list.size()];
        int j = 0;
        for(int i : list) {
            result[j++] = i;
        }
        return result;
    }
}