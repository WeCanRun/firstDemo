package com.wuyi.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        while(k-- > 0){
            int index = sc.nextInt();
            int i = 0, j = n - 1;
            while(i <= j){
                int mid = i + (j - i) / 2;
                if(a[mid] > index){
                    j = mid - 1;
                } else if(a[mid] < index){
                    i = mid + 1;
                }else {
                    i = mid;
                    break;
                }
            }

            for (int l = i; j < n; l++){
                a[l]--;
            }

            System.out.println( n - i);
        }
    }
}
