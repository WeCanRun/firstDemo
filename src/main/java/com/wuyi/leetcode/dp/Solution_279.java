package com.wuyi.leetcode.dp;

public class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏情况
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                System.out.println(String.format("dp[%d]:%d", i, dp[i]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_279 s = new Solution_279();
        s.numSquares(13);

    }
}
