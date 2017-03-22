/*
Given an integer, write a function to determine if it is a power of two.
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n&1) == 1) count++;
            n >>>= 1;
        }
        return count == 1;
    }
}

public class Solution_oneline {
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
}