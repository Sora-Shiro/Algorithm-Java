/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<>();
    int max;
    public List<List<Integer>> combine(int n, int k) {
        max = n;
        for(int i = 1; i <= n-k+1; i++) {
            list.add(i);
            calc(i, k-1);
            list.remove(list.size()-1);
        }
        return result;
    }
    
    private void calc(int start, int remain) {
        if(remain == 0) result.add(new ArrayList<Integer>(list));
        else {
            for(int i = start+1; i <= max; i++) {
                list.add(i);
                calc(i, remain-1);
                list.remove(list.size()-1);
            }
        }
    }
}