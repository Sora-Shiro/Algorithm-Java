/*
Given a positive integer num, write a function which returns True 
if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num/2 > 65536) return check(num, 0, 65536);
        return check(num, 0, num/2);
    }
    
    private boolean check(int num, int left, int right){
        if(left > right) return false;
        int mid = (left+right)/2;
        if(mid*mid - num < 0) return check(num, mid+1, right);
        else if(mid*mid - num > 0) return check(num, left, mid-1);
        return true;
    }
}