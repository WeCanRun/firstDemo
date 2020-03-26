package com.wuyi.leetcode.dp;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 */
public class Solutiion_377 {
    public int combinationSum4(int[] nums, int target) {

        if(nums == null ||(nums.length)== 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length ; i++ ) {
            for (int num : nums) {
                if (i >= num)
                    dp[i] += dp[i - num];
            }
            System.out.print(dp[i] + " ");
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solutiion_377 s = new Solutiion_377();
        int[] nums = {1,2,3};
        s.combinationSum4(nums, 3);

    }
}
