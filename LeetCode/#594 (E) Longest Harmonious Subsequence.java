/*
We define a harmonious array is an array where the difference between 
its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest 
harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note: The length of the input array will not exceed 20,000. 
 */

public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i : nums) {
            int time = 0;
            if(map.containsKey(i)) {
                time = map.get(i);
            }
            map.put(i, time+1);
        }
        int result = 0;
        for(int key : map.keySet()) {
            if(map.containsKey(key+1)) {
                int v1 = map.get(key);
                int v2 = map.get(key+1);
                result = Math.max(result, v1+v2);
            }
        }
        return result;
    }
}