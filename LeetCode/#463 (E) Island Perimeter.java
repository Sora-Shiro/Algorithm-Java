/*
You are given a map in form of a two-dimensional integer grid where 
1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island 
(i.e., one or more connected land cells). 
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
 */

public class Solution {
    int result = 0;
    
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    check(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void check(int[][] grid, int i, int j) {
        int add = 4;
        if(i != 0 && grid[i-1][j] == 1) add--;
        if(i != grid.length-1 && grid[i+1][j] == 1) add--;
        if(j != 0 && grid[i][j-1] == 1) add--;
        if(j != grid[0].length-1 && grid[i][j+1] == 1) add--;
        result += add;
    }
}

public class Solution_bad {
    int result = 0;
    
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    check(grid, i, j);
                } else {
                    if(i == 0) result++;
                    if(i == grid.length-1) result++;
                    if(j == 0) result++;
                    if(j == grid[0].length-1) result++;
                }
            }
        }
        return result;
    }
    
    private void check(int[][] grid, int i, int j) {
        if(i != 0 && grid[i-1][j] == 1) result++;
        if(i != grid.length-1 && grid[i+1][j] == 1) result++;
        if(j != 0 && grid[i][j-1] == 1) result++;
        if(j != grid[0].length-1 && grid[i][j+1] == 1) result++;
    }
}
