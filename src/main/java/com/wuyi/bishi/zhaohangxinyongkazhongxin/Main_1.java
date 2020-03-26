package com.wuyi.bishi.zhaohangxinyongkazhongxin;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int l = 0, r = str.length() - 1;
        int right = 0, left = 0;
        int[] res = new int[str.length()];
        for (int i = 0; i < res.length; ++i)
            res[i] = 1;

        while ( l <= r ){
            if(str.charAt(l) == 'R')
                right++;
        }
    }
}
