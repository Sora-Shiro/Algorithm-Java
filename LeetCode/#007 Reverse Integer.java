/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Hint:
Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class Solution {
	// 44 ms
    public int reverse(int x) {
        long xl = x;
		if (x < 0) {
			xl = -xl;
		}

		char[] c = new Long(xl).toString().toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (int i = c.length - 1; i >= 0; i--) {
			sb.append(c[i]);
		}
		
		Long l = new Long(sb.toString());
		if (l.longValue() > Integer.MAX_VALUE) {
			return 0;
		}
		
		int buff = l.intValue();
		if (x < 0) {
			buff = -buff;
		}
		return buff;
    }

    public int reverse_new(int x) {
        long result = 0;
		int digit = 0;

		while (x != 0) {
			digit = x % 10;
			result = (result * 10 + digit);
			x /= 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) result;
    }

    public int reverse_better(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}