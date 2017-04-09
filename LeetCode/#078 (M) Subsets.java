/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<>();
    int[] num;
    
    public List<List<Integer>> subsets(int[] nums) {
        num = nums;
        for(int i = 1; i <= nums.length; i++) {
            combine(i);
        }
        result.add(new ArrayList<Integer>());
        return result;
    }
    
    public void combine(int remain) {
        for(int i = 0; i < num.length; i++) {
            list.add(num[i]);
            calc(i, remain-1);
            list.remove(list.size()-1);
        }
    }
    
    private void calc(int start, int remain) {
        if(remain != 0) {
            for(int i = start+1; i < num.length; i++) {
                list.add(num[i]);
                calc(i, remain-1);
                list.remove(list.size()-1);
            }
        }
        else {
            result.add(new ArrayList<Integer>(list));
        }
    }
}

public class Solution_better {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}