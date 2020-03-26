package com.wuyi.leetcode.dp;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class Solution_91 {
    public int numDecodings1(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            if(s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2'
                    && s.charAt(i - 1) <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings2(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int n = s.length();
        if (n == 1)
            return 1;
        int ppre = 1, pre = 1, res = 0;
        for (int i = 2; i <= n ; i++) {
            if(s.charAt(i - 1) != '0'){
                res = pre;
            }

            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2'
                    && s.charAt(i - 1) <= '6') {
                 res += ppre;
                 ppre = pre;
                 pre = res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_91 s = new Solution_91();
        int res = s.numDecodings2("10");
        System.out.println(res);
    }
}
