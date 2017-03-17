/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */

import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if(input.length == 0 || k > input.length) return al;
        Arrays.sort(input);
        int i = 0;
        while(k-- > 0){
        	al.add(input[i++]);
        }
        return al;
    }
}