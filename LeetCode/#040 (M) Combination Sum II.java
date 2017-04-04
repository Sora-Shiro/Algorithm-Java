/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */

public class Solution {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

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
            if(i > offset && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            target -= nums[i];
            check(nums, target, list, i+1);
            target += nums[i];
            list.remove((Integer) nums[i]);
        }
    }
    
}