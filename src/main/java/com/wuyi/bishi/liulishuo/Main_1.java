package com.wuyi.bishi.liulishuo;

import java.util.*;

public class Main_1 {
    public static <Map> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int res = 0;
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a1 != 0 && a < b){
                res += a;
                a1--;
            } else
                res += b;
            sc.nextLine();
        }
        System.out.println(res);
        sc.close();

    }
}
