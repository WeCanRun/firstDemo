package com.wuyi.bishi.zhaohangxinyongkazhongxin;

import java.util.Scanner;

public class Main_2 {
    private static int[] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        res = new int[n];
        int[][] arr = new int[n][n];
        while(n-- > 1){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            arr[i][j] = sc.nextInt();
            sc.nextLine();
        }

        Main_2 main = new Main_2();
        main.helper(arr, 0);

        for (int a : res)
            System.out.print(a + " ");
        System.out.println();

    }

    private int helper(int[][] arr, int index){
        if(index == arr.length)
            return 0;

        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[index][i] != 0) {
                temp += arr[index][i];
                temp += helper(arr, index + 1);

               // System.out.println( "res[index]: " + res[index]);
                res[index] = Math.max(res[index], temp);
            }
        }
        return res[index];
    }
}
