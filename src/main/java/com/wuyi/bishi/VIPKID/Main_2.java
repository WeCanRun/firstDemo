package com.wuyi.bishi.VIPKID;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while(n != 0){
            n &= n - 1 ;
            res++;
        }
        System.out.println(res);
    }
}
