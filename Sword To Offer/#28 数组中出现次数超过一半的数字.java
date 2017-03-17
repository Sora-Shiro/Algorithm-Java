/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
如果不存在则输出0。
 */

import java.util.HashMap;
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if(len == 0) return 0;
        if(len == 1) return array[0];
        for(int i = 0; i < len; i++){
            if(map.get(array[i]) == null){
                map.put(array[i], 1);
                continue;
            }
            int times = map.get(array[i]);
            times++;
            if(times > len/2) return array[i];
            map.put(array[i], times);
        }
        return 0;
    }
}

class Solution {
public:
    int MoreThanHalfNum_Solution(vector<int> numbers) {
        int n = numbers.size();
        if (n == 0) return 0;
         
        int num = numbers[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (numbers[i] == num) count++;
            else count--;
            if (count == 0) {
                num = numbers[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == num) count++;
        }
        if (count > n/2) return num;
        return 0;
    }
};