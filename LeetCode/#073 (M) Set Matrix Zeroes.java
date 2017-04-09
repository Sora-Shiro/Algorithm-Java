/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

public class Solution {
    int[][] map;
    int rows, cols;
    
    public void setZeroes(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        map = matrix;
        find(0, -1);
    }
    
    private void find(int x, int y) {
        int k = y+1;
        for(int i = x; i < rows; i++) {
            for(int j = k; j < cols; j++) {
                if(map[i][j] == 0) {
                    find(i, j);
                    setZero(i, j);
                    return ;
                }
            }
            k = 0;
        }
    }
    
    private void setZero(int x, int y) {
        for(int i = 0; i < rows; i++) {
            map[i][y] = 0;
        }
        for(int i = 0; i < cols; i++) {
            map[x][i] = 0;
        }
    }
}

public class Solution_another {
    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}