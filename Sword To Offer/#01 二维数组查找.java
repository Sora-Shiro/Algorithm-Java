/*
题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


public class Solution {
    int width;
    int height;
    public boolean Find(int target, int [][] array) {
        width = array[0].length;
        height = array.length;
        int i = 0;
        int j = 0;
        return nextFind(i, j, array, target);
    }
    
    public boolean nextFind(int i, int j, int[][] array, int target) {
        if (i >= height || j >= width) {
            return false;
        }
        if (target == array[i][j]) {
            return true;
        }
        if (target > array[i][j]) {
            return nextFind(i + 1, j, array, target)
                    || nextFind(i, j + 1, array, target);
        }
        return false;
    }

    public boolean Find_better(int target, int [][] array) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }


}