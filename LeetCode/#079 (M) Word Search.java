/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

/*
https://discuss.leetcode.com/topic/85955/java-6-8ms-beats-97-99-though-i-don-t-know-why
 */

public class Solution {
    char[][] map;
    char[] path;
    boolean[][] used;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        if(word.length() == 0) return true;
        
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        map = board;
        path = word.toCharArray();
   
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(map[i][j] == path[0] && find(i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean find(int i, int j, int index) {
        if(index == path.length-1) return true;
        
        used[i][j] = true;
        
        if(i-1 >= 0 && !used[i-1][j] && map[i-1][j] == path[index+1]) {
            if(find(i-1, j, index+1)) return true;
        }
        if(i+1 < rows && !used[i+1][j] && map[i+1][j] == path[index+1]) {
            if(find(i+1, j, index+1)) return true;
        }
        if(j-1 >= 0 && !used[i][j-1] && map[i][j-1] == path[index+1]) {
            if(find(i, j-1, index+1)) return true;
        }
        if(j+1 < cols && !used[i][j+1] && map[i][j+1] == path[index+1]) {
            if(find(i, j+1, index+1)) return true;
        }
        
        used[i][j] = false;
        
        return false;
    }
}

public class Solution_improve {
    char[][] map;
    char[] path;
    int rows;
    int cols;
    
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        if(word.length() == 0) return true;
        
        rows = board.length;
        cols = board[0].length;
        map = board;
        path = word.toCharArray();
   
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(map[i][j] == path[0] && find(i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean find(int i, int j, int index) {
        if(index == path.length-1) return true;
        
        map[i][j] ^= 256;
        
        if(i-1 >= 0 && map[i-1][j] == path[index+1]) {
            if(find(i-1, j, index+1)) return true;
        }
        if(i+1 < rows && map[i+1][j] == path[index+1]) {
            if(find(i+1, j, index+1)) return true;
        }
        if(j-1 >= 0 && map[i][j-1] == path[index+1]) {
            if(find(i, j-1, index+1)) return true;
        }
        if(j+1 < cols && map[i][j+1] == path[index+1]) {
            if(find(i, j+1, index+1)) return true;
        }
        
        map[i][j] ^= 256;
        
        return false;
        
    }
}