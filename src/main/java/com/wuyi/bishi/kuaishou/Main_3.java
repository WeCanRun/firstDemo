package com.wuyi.bishi.kuaishou;


import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" " );
        String[] res = new String[str1.length + str2.length];
        int i = 0, j = 0, k = 0;
        while(i < str1.length && j < str2.length){
            if((k + 1) % 5 == 0 ){
                res[k++] = str2[j++];
            } else {
                res[k++] = str1[i++];
            }
        }

        while(i < str1.length)
            res[k++] = str1[i++];

        while (j < str2.length)
            res[k++] = str2[j++];


        for (String a : res )
            System.out.print(a + " ");
        System.out.println();
    }
}
