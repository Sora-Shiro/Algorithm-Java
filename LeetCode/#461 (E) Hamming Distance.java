/*
The Hamming distance between two integers is the number of positions at which 
the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class Solution {
    public int hammingDistance(int x, int y) {
        if(x == y) return 0;
        int result = 0;
        for (int bit = 1; bit != 0; bit <<= 1){
            if((x&bit) != (y&bit)) result++;
        }
        return result;
    }
}