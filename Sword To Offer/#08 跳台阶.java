/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution {
    public int JumpFloor(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;
		int a = 1;
		int b = 2;
		int c = 0;
		target -= 2;
		while(target != 0){
			c = a + b;
			a = b;
			b = c;
			target--;
		}
		return c;
    }
}