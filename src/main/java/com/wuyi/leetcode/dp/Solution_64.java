package com.wuyi.leetcode.dp;

/**
 *
 */
public class Solution_64 {
    public int minPathSum1(int[][] grid) {
        if (grid == null)
            return -1;
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < m; j++)
            dp[0][j] = dp[0][j] + grid[0][j];

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])
                        + grid[i][j];

        return dp[n - 1][m - 1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null)
            return -1;
        int n = grid.length;
        int m = grid[0].length;

        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++)
            dp[j] = dp[j - 1] + grid[0][j];

        for (int i = 1; i < n; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++)
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }

        return dp[m - 1];
    }

    public int minPathSum3(int[][] grid) {
        if (grid == null)
            return -1;
        int n = grid.length;
        int m = grid[0].length;

        for (int j = 1; j < m; j++)
            grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
            for (int j = 1; j < m; j++)
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
        }

        return grid[n - 1][m - 1];
    }
}
