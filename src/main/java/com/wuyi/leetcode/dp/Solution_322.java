package com.wuyi.leetcode.dp;

import java.util.Arrays;

public class Solution_322 {

    /**
     * 暴力递归解法
     * @param coins
     * @param amount
     * @return
     */
    int coinChange1(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0)
                continue;
            int sub = coinChange1(coins, amount - coin);
            if (sub != Integer.MAX_VALUE)
                min = Math.min(min, sub + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int coinChange2(int[] coins, int amount) {
       memo = new int[amount + 1];
       Arrays.fill(memo, -2);
       return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        if (memo[amount] != -2)
            return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0)
                continue;
            int sub = helper(coins, amount - coin);
            if (sub == -1)
                continue;
            min = Math.min(min, sub + 1);
        }

        memo[amount] = (min == Integer.MAX_VALUE)? -1 : min;
        System.out.print(memo[amount] + " ");
        return memo[amount];
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins){
                if (i >= coin)
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution_322 s = new Solution_322();
        int[] coins = {1,2, 5};

        int res = s.coinChange3(coins, 11);
//        for (int a : s.memo){
//            System.out.print(a + " ");
//        }
        System.out.println();
        System.out.println(res);
    }
}
