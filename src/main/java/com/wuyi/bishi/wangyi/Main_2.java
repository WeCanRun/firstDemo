package com.wuyi.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            boolean flag = false;
//            for (int i = 0; i < n; i++) {
//                if (i == 0 ){
//                    if(A[i + 1] + A[A.length - 1] <= A[0]){
//                        flag = true;
//                    }
//                } else if(i == A.length - 1) {
//                    if (A[A.length - 2] + A[0] <= A[A.length - 1])
//                        flag = true;
//                }else if(A[i - 1] + A[i + 1] < A[i]){
//                    flag = true;
//                }
//            }
            for(int i = 0; i < n; i ++){
                int pre = (i - 1 + n) % n;
                int sub = (i + 1) % n;
                if (a[pre] + a[sub] <= a[i])
                    flag = true;
            }
            if (flag){
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }

        }
    }


}
