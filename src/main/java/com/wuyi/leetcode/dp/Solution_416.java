package com.wuyi.leetcode.dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class Solution_416 {
    private boolean[][] dp;

    private boolean[] dp2;


    public boolean canPartition3(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) <= 1)
            return false;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if ((sum & 1) == 1)
            return false;

        int target = sum / 2;

        dp2 = new boolean[target + 1];
        dp2[0] = true;

        for (int j = 1; j < target + 1; j++)
            if (nums[0] == j) {
                dp2[j] = true;
                break;
            }

        for (int i = 1; i < n; i++){
            if (target >= nums[i])
                dp2[target] = dp2[target] || dp2[target - nums[i]];

            if (dp2[target])
                return true;

            for (int j = target; j >= nums[i]; j--) {
                dp2[j] = dp2[j] || dp2[j - nums[i]];
            }
        }

        return dp2[target];
    }

    public boolean canPartition2(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) <= 1)
            return false;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if ((sum & 1) == 1)
            return false;

        int target = sum / 2;

        dp2 = new boolean[target + 1];
        for (int j = 1; j < target + 1; j++)
            if (nums[0] == j) {
                dp2[j] = true;
                break;
            }

        for (int i = 1; i < n; i++)
            for (int j = target; j >= nums[i]; j--) {
                dp2[j] = dp2[j] || dp2[j - nums[i]];
            }
        return dp2[target];
    }

    public boolean canPartition(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) <= 1)
            return false;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];

        if ((sum & 1) == 1)
            return false;

        int target = sum / 2;

        dp = new boolean[n][target + 1];
        for (int j = 1; j < target + 1; j++)
            if (nums[0] == j) {
                dp[0][j] = true;
                break;
            }

        for (int i = 1; i < n; i++)
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > nums[i])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        Solution_416 s = new Solution_416();
        int[] nums = {1, 5, 11, 5};
        s.canPartition2(nums);

        for (int j = 0; j < s.dp2.length; j++)
            System.out.print(s.dp2[j] + " ");
        System.out.println();
    }
}
