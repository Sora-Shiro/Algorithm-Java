/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */

public class Solution_magic {
    public boolean isHappy(int n) {
        while (n > 6) {
            int next = 0;
            while (n != 0) {next += (n%10)*(n%10); n /= 10;}
            n = next;
        }
        return n == 1;
    }
}

public class Solution_pointer {
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }
    
    private int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}

public class Solution_hash {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
    	while (inLoop.add(n)) {
    		squareSum = 0;
    		while (n > 0) {
    		    remain = n%10;
    			squareSum += remain*remain;
    			n /= 10;
    		}
    		if (squareSum == 1) return true;
    		else n = squareSum;
    	}
    	return false;
    }
}