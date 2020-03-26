package com.wuyi.leetcode.dp;


/**
 * 经典的 0-1 背包问题
 */
public class Knaspack01 {
    private int[][] memo;
    private int[][] dp1;
    private int[] dp2;

    /**
     * 记忆化搜索解决
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knaspack1(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;
        if (memo[index][c] != 0)
            return memo[index][c];
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, bestValue(w, v, index - 1, c - w[index]) + v[index]);
        memo[index][c] = res;
        return res;
    }


    /**
     * 动态规划方法解决，使用额外的二维数组存储中间结果
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knaspack2(int[] w, int[] v, int C) {
        int n = w.length;
        dp1 = new int[n][C + 1];
        if (w.length != v.length || n == 0)
            return 0;
        for (int j = 0; j < C; j++)
            dp1[0][j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                dp1[i][j] = dp1[i - 1][j];
                if (j >= w[i])
                    dp1[i][j] = Math.max(dp1[i][j], dp1[i - 1][j - w[i]] + v[i]);

            }
        }

        return dp1[n - 1][C];
    }

    /**
     * 动态规划方法解决，使用额外的一维数组存储中间结果
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knaspack3(int[] w, int[] v, int C) {
        int n = w.length;
        dp2 = new int[C + 1];
        if (n != v.length || n == 0)
            return 0;

        for (int j = 0; j <= C; j++)
            dp2[j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++)
            for (int j = C; j >= w[i]; j--) {
                dp2[j] = Math.max(dp2[j], dp2[j - w[i]] + v[i]);

            }

        return dp2[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        Knaspack01 k = new Knaspack01();
        int res = k.knaspack3(w, v, 5);
        System.out.println(res);
    }
}
