package com.wuyi.leetcode.dp;

public class Solution_63 {
    int[] dp2;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        dp2 = new int[m];
        dp2[0] =1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j] == 1)
                    dp2[j] = 0;
                else if(j > 0)
                    dp2[j] += dp2[j - 1];
            }
        }
        return dp2[m - 1];
    }

    public static void main(String[] args) {
        Solution_63 s = new Solution_63();
        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                };

        int res2 = s.uniquePathsWithObstacles(grid1);
        for (int i = 0; i < s.dp2.length; i++)
            System.out.print(s.dp2[i] + " ");
        System.out.println();

        System.out.println(res2);
    }
}
