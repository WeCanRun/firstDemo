package com.wuyi.leetcode.dp;


/**
 * 70、爬楼梯：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Solution_70 {
    /**
     * 记忆化搜索，在 leetcode 中超时
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        if(n == 0 || n == 1)
            return 1;

        if(dp[n] != 0)
            return dp[n];

        dp[n] =  climbStairs1(n - 1) + climbStairs1(n - 2);
        return dp[n];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    /**
     * 动态规划优化，由于每次只使用到前面两个结果，所以可以只使用两个变量，而不使用一个数组
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        int res = 1;
        int ppre = 1;
        int pre = 1;
        for(int i = 2; i <= n; i++){
            res = ppre + pre;
            ppre = pre;
            pre = res;
        }


        return res;
    }

    public static void main(String[] args) {
        Solution_70 s = new Solution_70();
        long start = System.currentTimeMillis();
        int res = s.climbStairs2(38);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
    }
}
