/*
You have a total of n coins that you want to form in a staircase shape, 
where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 */

public class Solution {
    public int arrangeCoins(int n) {
        return (int)check(n, 1, n);
    }
    
    private long check(int n, long left, long right) {
        long mid = (left+right)/2;
        long sum = (1+mid)*mid/2;
        if(left > right) return left-1;
        if(sum == n) return mid;
        if(sum < n) return check(n, mid+1, right);
        if(sum > n) return check(n, left, mid-1);
        return 0;
    }
}

public class Solution_math {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}