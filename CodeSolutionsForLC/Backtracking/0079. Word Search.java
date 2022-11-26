/*
BFS / backtracking

1. time:

2. space: 
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // mark the element that has been used for current path 
        boolean[][] used = new boolean[m][n];  
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if the first letter matches, then match the followings
                if (board[i][j] == word.charAt(0) && 
                    backtracking(0, i, j, used, board, word)) 
                    return true;
            }
        }
        return false;   // not find
    }
    public boolean backtracking(int pos, int row, int col, boolean[][] used, 
                                char[][] board, String word) {
        if (pos == word.length()) return true; // all letters match
        // indexes out of bound / letter has been used / not match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || used[row][col] || board[row][col] != word.charAt(pos))
            return false;
        used[row][col] = true; // use it 
        if (backtracking(pos+1, row+1, col, used, board, word)
            || backtracking(pos+1, row-1, col, used, board, word)
            || backtracking(pos+1, row, col+1, used, board, word)
            || backtracking(pos+1, row, col-1, used, board, word))
            return true;
        used[row][col] = false;    // current path finish, not use it 
        return false;
    }
}