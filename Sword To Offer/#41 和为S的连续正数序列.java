/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> check;
		boolean rightAdd;
		int save = -1;
		for (int i = sum / 2 + 1; i >= 2; i--) {
			int begin = sum / i;
			if (begin == save) continue;
			save = begin;
			int add = begin;
			check = new ArrayList<>();
			check.add(begin);
			int j = 1;
			rightAdd = true;
			while (add < sum) {
				int toAdd;
				if (rightAdd) {
					toAdd = begin + j;
					if (toAdd > sum) break;
					check.add(toAdd);
					add += toAdd;
				} else {
					toAdd = begin - j;
					if (toAdd < 1) break;
					check.add(toAdd);
					add += toAdd;
					j++;
				}
				rightAdd = !rightAdd;
			}
			if (add == sum) {
				Collections.sort(check);
				result.add(check);
			}
		}
		return result;
    }
}


import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> check;
		int small = 1;
		int big = 2;
		int add = small + big;
		while(big<sum && small<(sum+1)/2){
			if(add > sum) {
				add -= small;
				small++;
			}
			if(add < sum) {
				big++;
				add += big;
			}
			if(add == sum) {
				check = new ArrayList<>();
				for(int i = small; i <= big; i++) check.add(i);
				result.add(check);
				add -= small;
				small++;
			}
		}
		return result;
    }
}