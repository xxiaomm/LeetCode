/*
caution: calculate the index of boxes; integer -> char
1. time: 

2. space
*/
class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    public boolean backtracking(char[][] board) {
        for (int i = 0 ; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)){
                            board[i][j] = k;
                            if (backtracking(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == val) return false;
            if (i != row && board[i][col] == val) return false;
            // 所在box的index
            int boxRow = row/3, boxCol = col/3;
            // 如何遍历一个box中的9个数字
            if (3*boxRow + i/3 != row && boxCol + i%3 != col && 
                board[3 * boxRow + i/3][3 * boxCol + i%3] == val)
                return false;
        }
        return true;
    }
}




/*

*/
class Solution {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];
    public void solveSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    row[i][c-'0'] = true;
                    col[j][c-'0'] = true;
                    box[i/3 * 3 + j/3][c-'0'] = true;
                }
            }
        }
        
        backtracking(board);
    }
    public boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (!isValid(i, j, c))
                            continue;
                        // System.out.println(c);
                        board[i][j] = c;
                        row[i][c-'0'] = true;
                        col[j][c-'0'] = true;
                        box[i/3 * 3 + j/3][c-'0'] = true;
                        if (backtracking(board))
                            return true;
                        board[i][j] = '.';
                        row[i][c-'0'] = false;
                        col[j][c-'0'] = false;
                        box[i/3 * 3 + j/3][c-'0'] = false;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(int i, int j, char c) {
        if (row[i][c-'0'] || col[j][c-'0'] 
            || box[i/3 * 3+j/3][c-'0'])
            return false;
        return true;
    }
}