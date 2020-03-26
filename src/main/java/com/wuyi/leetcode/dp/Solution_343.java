package com.wuyi.leetcode.dp;

public class Solution_343 {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j <= i; j++)
                dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);

        return dp[n];
    }

    /**
     * 记忆化搜素
     *
     * @param n
     * @return
     */
    private int helper(int n) {
        if (n == 1)
            return 1;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        if (dp[n] != 0)
            return dp[n];
        for (int i = 1; i < n; i++)
            max = max3(max, i * (n - i), i * helper(n - i));
        dp[n] = max;
        return max;
    }

    private int max3(int max, int a, int b) {
        return Math.max(max, Math.max(a, b));
    }

}
