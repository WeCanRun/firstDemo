package com.wuyi;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a  = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(i != 0){
                a[i] += a[i - 1];
            }
            System.out.println("A[i]:" + a[i]);
        }
        int m = sc.nextInt();
        while(m-- > 0){
            int q = sc.nextInt();
            int l = 0, r = n - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(a[mid] > q){
                    r = mid - 1;
                } else if(a[mid] < q){
                    l = mid + 1;
                } else {
                   l = mid;
                   break;
                }
            }
            System.out.println(l + 1);
        }
    }
}