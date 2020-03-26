package com.wuyi.bishi.shencewangluo;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long k = sc.nextLong();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");
            long[] a = new long[n];
            for (int i = 0; i < n; i++){
                a[i] = Long.parseLong(str[i]);
            }
            boolean suc = false;
            for (int q = 0; q < n; q++){
                int i = q + 1, j = a.length - 1;
                while (i < j){
                    long sum = a[q] + a[i] + a[j];
                    if (sum < k)
                        i++;
                    else if (sum > k)
                        j--;
                    else {
                        suc = true;
                        System.out.println(a[q] + " " + a[i] + " " + a[j]);
                    }
                }
            }
            if (!suc){
                System.out.println("-1 -1 -1");
            }
        }
    }
}
