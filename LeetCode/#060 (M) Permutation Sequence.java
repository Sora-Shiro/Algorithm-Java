/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */

/*
做出来比较有成就感的一道题，虽然理论部分还无法自证 :)
https://discuss.leetcode.com/topic/85601/java-recursive-without-factorials-array
 */

public class Solution {
    
    List<Integer> list = new ArrayList<Integer>();
    StringBuilder result = new StringBuilder();
    
    public String getPermutation(int n, int k) {
        
        for(int i = 0; i < n; i++) {
            list.add(i+1);
        }
        
        int total = 1;
        for(int i = 2; i <= n-1; i++) {
            total *= i;
        }
        
        return get(n-1, total, k);
        
    }
    
    private String get(int n, int interval, int k){
        
        if(list.size() == 1) {
            result.append(list.get(0));
            return result.toString();
        }
        int index = ((k-1) / interval) % list.size();
        result.append(list.get(index));
        list.remove(index);
        
        return get(n-1, interval/n, k);
        
    }
}