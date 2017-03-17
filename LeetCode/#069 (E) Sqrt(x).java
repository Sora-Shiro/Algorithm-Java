/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */

public class Solution {
    public int mySqrt(int x) {
		if (x <= 1) return x;
		int left = 1;
		int right = (int) Math.sqrt(Integer.MAX_VALUE);
		int mid = (left + right) / 2;
		while (right - left > 1) {
			if (mid * mid > x) right = mid;
			else if (mid * mid < x) left = mid;
			else if (mid * mid == x) return mid;
			mid = (left + right) / 2;
		}
		return right * right > x ? left : right;
	}
}