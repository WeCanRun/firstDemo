package com.wuyi.bishi.threexiazero;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述：
 * 在一个古老的国度，这个国家的人并不懂得进位，但是对取模情有独钟，因此诞生了一个经典的问题，
 * 给出两个在 m 进制下含有 n 位的数字，你可以分别将这两个数各位上的数字重新排列，
 * 然后将两个数按位对应相加并分别对 m 取模，这样显然可以得到一个新的 m 进制下的 n 位数
 * (可能存在前导 0)，但是这个结果是不唯一的，问题来了，按照这样的操作，能够得到的
 * 最大的 m 进制下的数字是多少呢。
 *
 * 输入
 * 输入第一行包含两个正整数 n,m 分别表示数字含有 n 位，和在 m 进制下。
 *
 * 输入第二行和第三行分别包含 n 个整数，中间用空格隔开，每个整数都在 0 到 m-1 之间。
 * 每行第 i 个数表示的是当前数第 i 位上的数字。
 *
 * 输出
 * 输出包含 n 个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，
 * 如 6 在 2 进制下输出 3 位的结果是 1 1 0。
 *
 * 样例输入
 * 5 5
 * 4 4 1 1 1
 * 4 3 0 1 2
 * 样例输出
 * 4 4 3 3 2
 *
 * 提示
 * 4 4 1 1 1 →1 4 1 4 1
 * 4 3 0 1 2 →3 0 2 4 1（重排序列不唯一，数位相加后的数字为 4 4 3 8 2，对5取模即可 ）
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int j = 0; j < n; j++)
            b[j] = sc.nextInt();

        Integer[] dp = new Integer[n];
        for (int i = 0; i < n; i++){
            int max = Integer.MIN_VALUE;
            int y = -1;
            for (int j = 0; j < n; j++){
                if (!used[j]){
                    int value = (a[i] + b[j]) % m;
                    if (max < value){
                       max = value;
                       y = j;
                   }
                }
            }
            dp[i] = max;
            used[y] = true;
        }
        Arrays.sort(dp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }
}
