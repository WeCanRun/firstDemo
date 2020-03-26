package com.wuyi.leetcode.blacktracking;

/**
 * 有效的数独
 */
public class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    int k = i / 3 * 3 + j / 3;
                    if (row[i][index]
                            || col[j][index] || block[k][index])
                        return false;

                    row[i][index] = true;
                    col[j][index] = true;
                    block[k][index] = true;
                }
            }
        return true;
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
        Solution_36 solution = new Solution_36();
        //solution.printBoard(board);
        boolean res = solution.isValidSudoku(board);
        System.out.println(res);
    }
}
