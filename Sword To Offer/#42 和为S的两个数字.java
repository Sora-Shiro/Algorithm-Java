/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。 
 */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if(array[i] + array[j] == sum) {
				result.add(array[i]);
				result.add(array[j]);
				return result;
			}
			if(array[i] + array[j] < sum) i++;
			if(array[i] + array[j] > sum) j--;
		}
		return result;
    }
}