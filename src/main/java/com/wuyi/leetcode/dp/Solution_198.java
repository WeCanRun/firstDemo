package com.wuyi.leetcode.dp;


import sun.nio.cs.ext.MacArabic;

/**
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class Solution_198 {

    public int rob1(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[n - 1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int ppre = 0;
        int pre = 0;
        int res = 0;

        for(int num : nums){
            pre = res;
            res = Math.max(ppre + num, pre);
            ppre = pre;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_198 s = new Solution_198();
        int nums[] = {1,3,1};
        int res = s.rob2(nums);
        System.out.println(res);
    }
}
