package com.wuyi.bishi.bilibili;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = 1, right = 1;
        long res = 0;
        while (right <= n) {
            long sum = 0;
            for (int i = left; i <= right; i++)
                sum += i;

            if(sum == n) {
                res++;
                left++;
            } else if(sum < n)
                right++;
            else
                left++;
        }
        System.out.println(res);

    }
}
