package com.wuyi.bishi.qianxin;

import java.util.Scanner;

public class Main_1 {
    private static long answer(int n){
        if(n % 5 == 0)
            return n / 5;

        long res = 0;
        while(n >= 5 && n % 5 != 0){
            int num = n / 5;
            if(num == 0){
                --n;
                ++res;
            }
            res += num;
            n -= num;
        }

        if(n == 1 || n == 5)
            res += 1;
        if(n == 2 || n == 3)
            res += 2;
        if(n == 4)
            res += 4;

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = answer(n);
        System.out.println(res);
    }
}
