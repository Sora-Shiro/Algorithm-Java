/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 */

public class Solution_better {
    public int getSum(int a, int b) {
        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }
}

public class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int bit = 1;
        int carry = 0;
        int check;
        int i = 0;
        while(bit != 0){
            
            check = (a&bit) ^ (b&bit) ^ (carry << i++);
            result |= check;
            
            int one_count = 0;
            if((a & bit) != 0) one_count++;
            if((b & bit) != 0) one_count++;
            if((carry) != 0) one_count++;
            if(one_count >= 2) carry = 1;
            else carry = 0;
            
            bit <<= 1;
        }
        return result;
    }
}