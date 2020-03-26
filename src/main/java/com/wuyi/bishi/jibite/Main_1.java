package com.wuyi.bishi.jibite;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        String S = arr[0];
        String t = arr[1];
        int res = subString(S, t);
        System.out.println(res);
    }

    private static int subString(String S, String t){
        int n = S.length() - 1, m = t.length() - 1;
        while(n >= 0 && m >= 0){
            if(S.charAt(n) == t.charAt(m)){
                --n;
                --m;
            } else
                --n;
        }
        return m < 0 ? n + 2 : 0;
    }
}
