package com.wuyi.bishi.shencewangluo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(":");
        String[] str2 = sc.nextLine().split(":");
        int[] a1 = new int[3];
        int[] a2 = new int[3];
        int[] add = new int[3];
        for (int i = 2; i >= 0; i--){
            a1[i] = Integer.parseInt(str1[i]);
            a2[i] = Integer.parseInt(str2[i]);
            int temp = a1[i] + a2[i];
            if (i != 2)
                temp += add[i + 1];

            if(temp >= 60){
                temp -= 60;
                add[i] = 1;
            }
            if (i == 0 && temp >= 24){
                temp -= 24;
            }
            a2[i] = temp;
        }

        for (int i = 0; i < 3; i++){

            if(a2[i] < 10)
                System.out.print(0);

            System.out.print(a2[i]);
            if (i != 2)
                System.out.print(":");
        }
        System.out.println();
    }
}
