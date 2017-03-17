/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class Solution {
    public int RectCover(int target) {
        if(target == 0) return 0;
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