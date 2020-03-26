package com.wuyi.wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int q = sc.nextInt();

        int[] index = new int[q];

        for (int i = 0; i < q; i++) {
            index[i] = sc.nextInt();
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] <= a[index[i] - 1]) {
                    cnt++;
                }
            }
            double res = (double)(cnt - 1) * 100 / n;
            System.out.println(String.format("%.6f",res));

        }

    }

}
