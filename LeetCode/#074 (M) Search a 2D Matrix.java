/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int mid;
        int left = 0, right = rows-1;
        while(left < right) {
            mid = (left + right) / 2;
            if(matrix[mid][0] > target) {
                right = mid;
            } else if (matrix[mid][0] < target) {
                left = mid+1;
            } else {
                return true;
            }
        }

        if(target < matrix[left][0]) left--;
        if(left < 0) return false;

        int group = left;
        left = 0;
        right = cols-1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(matrix[group][mid] > target) {
                right = mid-1;
            } else if (matrix[group][mid] < target) {
                left = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}

public class Solution_better {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        
        int begin = 0, end = row_num * col_num - 1;
        
        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];
            
            if( mid_value == target){
                return true;
            
            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return false;
    }
}