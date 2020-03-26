package com.wuyi.leetcode.dp;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * <p>
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * <p>
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。
 * 每个 0 和 1 至多被使用一次。
 * <p>
 * 注意:
 * <p>
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 * <p>
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * <p>
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 */
public class Solution_474 {

    /**
     * 二维背包问题
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */

    private int[][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int count0 = 0, count1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    count0++;
                else
                    count1++;
            }

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_474 s = new Solution_474();

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int res = s.findMaxForm(strs, 5, 3);
        for (int i = 0; i < s.dp.length; i++){
            for (int j = 0; j < s.dp[0].length; j++)
                System.out.print(s.dp[i][j] + " ");
            System.out.println();
        }

        System.out.println(res);
    }
}
