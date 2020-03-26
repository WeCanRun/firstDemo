package com.wuyi.bishi.qunaer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] arr  = new int[str.length];
        for(int i = 0; i < str.length ; ++i)
            arr[i] = Integer.parseInt(str[i]);

        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < arr.length; j += n) {
                res[i] += arr[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int  a : res) {
            max = Math.max(max, a);
            //System.out.println(a);
        }
        System.out.println(max);
    }

}
