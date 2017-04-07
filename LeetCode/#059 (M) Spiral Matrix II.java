/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        
        int count = 1;
        
        while(count != n*n + 1) {
            
            for(int i = colStart; i <= colEnd; i++){
                result[rowStart][i] = count++;
            }
            
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++){
                result[i][colEnd] = count++;
            }
            
            colEnd--;
 
            for(int i = colEnd; i >= colStart; i--){
                result[rowEnd][i] = count++;
            }
            
            rowEnd--;
            
            for(int i = rowEnd; i >= rowStart; i--){
                result[i][colStart] = count++;
            }
            
            colStart++;
            
        }
        
        return result;
    }
}