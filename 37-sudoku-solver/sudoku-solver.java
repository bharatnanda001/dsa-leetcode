class Solution {
    static int check = 0;

    public boolean isSafe(char[][] board, int row, int col, char num) {
        // row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }

        // col check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        // 3×3 grid check
        int nRow = (row / 3) * 3;
        int nCol = (col / 3) * 3;

        for (int i = nRow; i < nRow + 3; i++) {
            for (int j = nCol; j < nCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        check = 0;
        solve(board, 0, 0);
    }

    public void solve(char[][] board, int row, int col) {

        // If reached last row → solved
        if (row == 9) {
            check = 1;
            return;
        }

        // Calculate next cell
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        if (board[row][col] == '.') {

            for (char ch = '1'; ch <= '9'; ch++) {

                if (isSafe(board, row, col, ch)) {

                    board[row][col] = ch;

                    solve(board, nextRow, nextCol);

                    if (check == 1)
                        return; // solution found → stop

                    board[row][col] = '.'; // backtrack
                }
            }

        } else {
            solve(board, nextRow, nextCol);
        }
    }
}