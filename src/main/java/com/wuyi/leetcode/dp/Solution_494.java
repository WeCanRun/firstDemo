package com.wuyi.leetcode.dp;

public class Solution_494 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum < S || ((S + sum) & 1) == 1 ? 0 : helper(nums, (S + sum) >>> 1);
    }

    private int helper(int[] nums, int P){
        int[] dp = new int[P + 1];
        dp[0] = 1;
        for (int num :nums)
            for (int i = P; i >= num; i--)
                dp[i] += dp[i - num];


        return dp[P];
    }
}
