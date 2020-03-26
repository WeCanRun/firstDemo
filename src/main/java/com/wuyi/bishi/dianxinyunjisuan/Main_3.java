package com.wuyi.bishi.dianxinyunjisuan;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1, str.length() - 1).split(",\\s+");
        long[] arr = new long[strs.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Long.parseLong(strs[i]);

        Main_3 main = new Main_3();
        long res = main.answer(arr);
        System.out.println(res);
    }

    private long answer(long[] arr){
        long max = Long.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            long sum = 0;
            for(int j = i; j >= 0; j--){
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
