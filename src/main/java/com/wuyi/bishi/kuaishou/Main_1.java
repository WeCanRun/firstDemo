package com.wuyi.bishi.kuaishou;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        boolean res = false;
        while(m-- > 0){
            String[] s = sc.nextLine().split(" ");
            String[] str1 = s[0].split("\\.");
            String[] str2 = s[1].split("\\.");

            for (int k = 0; k < Math.max(str1.length, str2.length); k++){
                int i = k < str1.length ? Integer.valueOf(str1[k]) : 0;
                int j = k < str2.length ? Integer.valueOf(str2[k]) : 0;
                if (i < j)
                    res = true;
            }
            System.out.println(res);
        }
    }
}
