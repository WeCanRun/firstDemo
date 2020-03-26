package com.wuyi.bishi.beike;

/**
 * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的 90%，
 * 那么对于这 N 个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
 * <p>
 * 输入
 * 第一行 N，表示参赛人数（2<=N<=10^5）
 * <p>
 * 第二行 N 个正整数表示体重（0 < 体重 <=10^8）
 * <p>
 * 输出
 * 一个数，表示最多能进行的比赛场数
 * <p>
 * <p>
 * 样例输入
 * 5
 * 1 1 1 1 1
 * 样例输出
 * 10
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 2 && n <= Math.pow(10, 5)) {
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            int res = 0;
            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++){
//                    if (a[i] >= a[j] * 0.9)
//                        res++;
//                }

                int l = i + 1, r = n - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;

                    if (a[i] < a[mid] * 0.9) {
                        l = mid + 1;
                    } else if (a[i] > a[mid] * 0.9) {
                        r = mid - 1;
                    } else {
                        while(a[mid--] == a[mid]);
                        l = mid;
                    }
                }
                res += l - 1;
            }

            System.out.println(res);
        }
    }
}
