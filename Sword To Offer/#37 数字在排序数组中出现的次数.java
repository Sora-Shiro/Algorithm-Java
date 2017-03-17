/*
统计一个数字在排序数组中出现的次数。
 */

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
		int i = 0;
		for(; i < array.length && array[i] != k; i++) ;
		if(i == array.length) return 0;
		int save = i;
		for(; i < array.length && array[i] == k; i++) ;
		return i - save;
    }
}