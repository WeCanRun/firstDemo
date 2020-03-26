package com.wuyi.leetcode.blacktracking;

public class Solution_130 {
    private int rows;
    private int cols;
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean isEdge(int i, int j) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }

    private boolean isError(int i, int j) {
        return i < 0 || i >= rows || j < 0 || j >= cols;
    }

    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0)
            return;
        cols = board[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (isEdge(i, j))
                    dfs(board, i, j);
            }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';

            }
    }

    private void dfs(char[][] board, int i, int j) {

        if (isError(i, j) || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        System.out.print(i + ":" + j + ",");
        for (int k = 0; k < 4; k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            dfs(board, newX, newY);
        }
    }

    public static void main(String[] args) {
        Solution_130 s= new Solution_130();
        char[][] grid1 = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };


        s.solve(grid1);
        for (char[] c : grid1){
            for (char ch : c){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
