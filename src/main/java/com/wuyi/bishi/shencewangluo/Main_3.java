package com.wuyi.bishi.shencewangluo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str1 = sc.nextLine().split(" ");
        int m = sc.nextInt();
        String[] str2 = sc.nextLine().split(" ");
        long[] N = new long[n];
        long[] M = new long[m];
        for (int i = 0; i < n; i++)
            N[i] = Long.parseLong(str1[i]);

        for (int i = 0; i < m; i++)
            M[i] = Long.parseLong(str2[i]);
        Arrays.sort(N);
        Arrays.sort(M);
        int res = 0;
        int i = 0, j = 0;
        while(i < n && j < m){
            if (N[i] <= M[j]){
                res++;
                i++;
            }
            j++;
        }
        System.out.println(res);
    }
}
