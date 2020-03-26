package com.wuyi.leetcode.dp;

public class Solution_62 {
    private int[][] dp;
    private int[] dp2;

    public int uniquePaths1(int m, int n) {
        dp = new int[n][m];

        for (int j = 0; j < m; j++)
            dp[0][j] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * 解法二
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        dp2 = new int[m];
        dp2[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0)
                    dp2[j] += dp2[j - 1];
            }
        }
        return dp2[m - 1];
    }

    public static void main(String[] args) {
        Solution_62 s = new Solution_62();
        int res = s.uniquePaths1(7, 3);
        for (int i = 0; i < s.dp.length; i++) {
            for (int j = 0; j < s.dp[0].length; j++)
                System.out.print(s.dp[i][j] + " ");
            System.out.println();
        }
        System.out.println(res);

        int res2 = s.uniquePaths2(7, 3);
        for (int i = 0; i < s.dp2.length; i++)
            System.out.print(s.dp2[i] + " ");
        System.out.println();

        System.out.println(res2);
    }
}
