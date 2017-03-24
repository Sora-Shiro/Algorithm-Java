/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */

public class Solution {
    public int addDigits(int num) {
        if(num <= 9) return num;
        int remain = num % 9;
        return remain == 0 ? 9 : remain;
    }
}

public class Solution_faster {
    public int addDigits(int num) {
        return 1 + (num-1)%9;
    }
}
