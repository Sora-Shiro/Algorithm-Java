/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Solution {
    public void reOrderArray(int [] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddI = 0;
        int evenI = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) != 0) {
                odd[oddI++] = array[i];
            } else {
                even[evenI++] = array[i];
            }
        }
        for(int i = 0; i < evenI; i++){
            odd[oddI++] = even[i];
        }
        for(int i = 0; i < array.length; i++){
            array[i] = odd[i];
        }
    }
}
