/*
box: // box: row/3, col/3
box内元素: board[3 * row/3 + i/3][3 * col/3 + i%3]
1. time:

2. space:
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) 
                        return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == val) return false;
            if (i != col && board[row][i] == val) return false;
            // box: row/3, col/3
            if ((3 * row/3 != row && 3 * col/3 != col) &&
                board[3 * row/3 + i/3][3 * col/3 + i%3] == val)
                return false;
        }
        return true;
    }
}