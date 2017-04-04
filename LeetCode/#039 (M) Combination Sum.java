/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */

public class Solution {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates.length == 0) return result;

        Arrays.sort(candidates);

        check(candidates, target, new ArrayList<Integer>(), 0);


        return result;

    }

    private void check(int[] nums, int target, List<Integer> list, int offset) {

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = offset; i < nums.length && nums[i] <= target; i++) {
            list.add(nums[i]);
            target -= nums[i];
            check(nums, target, list, i);
            target += nums[i];
            list.remove((Integer) nums[i]);
        }
    }
    
}