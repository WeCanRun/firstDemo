package com.wuyi.leetcode.dp;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution_120 {
    private int min = Integer.MAX_VALUE;

    int minimumTotal1(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return min;
    }

    private void dfs(List<List<Integer>> triangle, int depth, int index, int value) {
        if (depth == triangle.size())
            return;
        if (depth == triangle.size() - 1 && value + triangle.get(depth).get(index) < min)
            min = value + triangle.get(depth).get(index);
        dfs(triangle, depth + 1, index, value + triangle.get(depth).get(index));
        dfs(triangle, depth + 1, index + 1, value + triangle.get(depth).get(index));
    }

    int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int j = 0; j < n; j++)
            dp[j] = triangle.get(n - 1).get(j);
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
        return dp[0];
    }

}
