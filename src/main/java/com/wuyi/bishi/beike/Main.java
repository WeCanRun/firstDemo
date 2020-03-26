package com.wuyi.bishi.beike;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        if (n >= 2 && n <= 100) {
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long min = Long.MAX_VALUE;
            int i = 0, j = 0;
            for (int k = 1; k < n; k++) {
                long temp = Math.abs(a[k] - a[k - 1]);
                if (temp < min) {
                    min = temp;
                    i = k - 1;
                    j = k;
                }
            }
            System.out.println(a[i] + " " + a[j]);
        }
    }
}
