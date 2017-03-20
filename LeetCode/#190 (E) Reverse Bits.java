/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
	    int bit = 31;
        while (n != 0) {
            if ((n & 1) == 1) result += 1 << bit;
            bit--;
            n >>>= 1;
        }
        return result;
    }
}