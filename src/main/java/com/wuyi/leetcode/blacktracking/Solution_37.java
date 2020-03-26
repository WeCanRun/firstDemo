package com.wuyi.leetcode.blacktracking;

/**
 * 解数独
 */
public class Solution_37 {
    private int n;
    private int n0;
    private boolean[][] row;
    private boolean[][] col;
    private boolean[][] block;
    private char[][] board;

    public void solveSudoku(char[][] board) {
        if (board == null || (this.n = board.length) == 0 || n != board[0].length){
            System.out.println("请输入正确的数独！");
            return;
        }

        //this.n = board.length;
        this.n = n;
        this.n0 = n / 3;
        this.row = new boolean[n][n];
        this.col = new boolean[n][n];
        this.block = new boolean[n][n];
        this.board = board;

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j++){
                if (this.board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    row[i][index] = true;
                    col[j][index] = true;
                    block[i / n0 * n0 +  j / n0][index] = true;
                }
            }
        dfs(0,0);
    }

    private boolean dfs(int i, int j) {
        while(board[i][j] != '.'){
            if (++j >= 9){
                ++i;
                j = 0;
            }

            if (i >= 9)
                return true;
        }
        for (char c = '1'; c <= '9'; c++){
            int index = c - '1';
            if (!row[i][index] && !col[j][index] && !block[i / n0 * n0 + j / n0][index]){
                board[i][j] = c;
                row[i][index] = true;
                col[j][index] = true;
                block[i / n0 * n0 + j / n0][index] = true;
                if (dfs(i,j))
                    return true;
                board[i][j] = '.';
                row[i][index] = false;
                col[j][index] = false;
                block[i / n0 * n0 + j / n0][index] = false;
            }
        }
        return false;
    }
    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution_37 solution = new Solution_37();
        //solution.printBoard(board);
        solution.solveSudoku(board);
        solution.printBoard(board);
    }
}
