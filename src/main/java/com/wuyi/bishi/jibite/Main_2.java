package com.wuyi.bishi.jibite;


import java.util.Scanner;

public class Main_2 {
    private int res = 0;

    private boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int [n + 1][n + 1];
        while(m-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int data = sc.nextInt();
            arr[i][j] = data;

            sc.nextLine();
        }


        Main_2 main = new Main_2();
        main.visited = new boolean[n+1][n+1];

        for (int i = 1; i < n + 1; i++){
            if(arr[1][i] != 0 && main.visited[1][i]);

        }
    }

    private int need(int[][] arr, int index){
        if(index == arr.length)
            return res;

        int len = arr.length;
        for (int i = 0; i < len; i++){

            if(!visited[index][i] && arr[index][i] != 0){
                visited[index][i] = true;
            }

        }
        return -1;
    }
}
