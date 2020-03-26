package com.wuyi.bishi.beike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 小希偶然得到了传说中的月光宝盒，然而打开月光宝盒需要一串密码。虽然小希并不知道密码具体是什么，
 * 但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000) 的序列 a (-10^9 <= a [i] <= 10^9)
 * 的范围内。下面写着一段话：密码是这个序列的最长的严格上升子序列的长度 (严格上升子序列是指，
 * 子序列的元素是严格递增的，例如: [5,1,6,2,4] 的最长严格上升子序列为 [1,2,4])，
 * 请你帮小希找到这个密码。
 * <p>
 * <p>
 * 输入
 * 第 1 行：1 个数 N，N 为序列的长度 (2<=N<=50000)
 * <p>
 * 第 2 到 N+1 行：每行 1 个数，对应序列的元素 (-10^9 <= a [i] <= 10^9)
 * <p>
 * 输出
 * 一个正整数表示严格最长上升子序列的长度
 * <p>
 * <p>
 * 样例输入
 * 8
 * 5
 * 1
 * 6
 * 8
 * 2
 * 4
 * 5
 * 10
 * 样例输出
 * 5
 */
public class Main_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine().trim());
        long[] nums = new long[n];
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            long temp = Long.valueOf(br.readLine().trim());
            nums[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            long max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    max = Math.max(max, dp[j] + 1);
                }

            }
            dp[i] = max;
        }

        for (long t : dp)
            System.out.print(t + " ");
        System.out.println();
        System.out.println(Arrays.stream(dp).max().orElse(0));

    }
}

