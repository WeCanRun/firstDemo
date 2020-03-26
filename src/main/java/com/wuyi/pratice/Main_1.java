package com.wuyi.pratice;

import java.util.Arrays;
import java.util.Scanner;

//神策网络 2020 届秋招 v2
public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[] data = new int[k];
        for (int i = 0; i < k; i++)
            data[i] = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.sort(data);

    }
}
