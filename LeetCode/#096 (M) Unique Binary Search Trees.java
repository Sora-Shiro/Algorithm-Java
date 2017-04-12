/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int numTrees(int n) {
        map.put(0, 1);
        if(map.containsKey(n)) return map.get(n);
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result += calc(i-1) * calc(n-i);
        }
        return result;
    }
    
    private int calc(int i) {
        if(map.containsKey(i)) return map.get(i);
        int result = 0;
        for(int j = 1; j <= i; j++) {
            result += calc(j-1) * calc(i-j);
        }
        map.put(i, result);
        return result;
    }
}

public class Solution_better {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
        
        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
    
        return G[n];
    }
}