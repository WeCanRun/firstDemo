package com.wuyi.bishi.bilibili;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int res = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); ++i){
            if(str1.charAt(i) == str2.charAt(i))
                continue;

            res++;
        }
        System.out.println(res);

    }
}
