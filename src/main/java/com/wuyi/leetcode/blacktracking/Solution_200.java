package com.wuyi.leetcode.blacktracking;

public class Solution_200 {
    private boolean[][] visited;
    private int n;
    private int m;
    private char[][] grid;
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean isArea(int x, int y) {
        return x < n && x >= 0 && y >= 0 && y < m;
    }

    public int numIslands(char[][] grid) {
         n = grid.length;

        if (n == 0)
            return  0;
        m = grid[0].length;
        visited = new boolean[n][m];
        this.grid = grid;

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && this.grid[i][j] == '1') {
                    dfs(i, j);
                    res++;
                    System.out.println("add ");
                }

        return res;
    }

    private void dfs(int i, int j) {
        System.out.println(true);
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (isArea(newX, newY) && !visited[newX][newY] && this.grid[newX][newY] == '1')
                dfs(newX, newY);
        }
        return;
    }

    public static void main(String[] args) {
        Solution_200 s= new Solution_200();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};


        int res = s.numIslands(grid1);
        System.out.println(res);
    }
}

