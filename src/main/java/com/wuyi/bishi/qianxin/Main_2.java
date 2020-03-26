package com.wuyi.bishi.qianxin;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        int[] a = new int[str1.length];
        int[] b = new int[str2.length];
        for (int i = 0; i < str1.length; i++)
            a[i] = Integer.parseInt(str1[i]);
        for (int i = 0; i < str2.length; i++)
            b[i] = Integer.parseInt(str2[i]);
        int k = sc.nextInt();
        sc.close();
        int res = 0;
        int[] hash = new int[str2.length];

        for (int i = 0; i < str2.length; i++) {
            if (b[i] == k) {
                res += 2;
                a[i] = -1;
            }

            if (a[i] == k)
                res++;
        }
        System.out.println(res);
    }
}
