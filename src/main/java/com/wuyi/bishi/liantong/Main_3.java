package com.wuyi.bishi.liantong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String[] w = str[0].split(",");
        int m = Integer.parseInt(str[1]);
        int n = Integer.parseInt(str[2]);
        int[] price = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = Integer.parseInt(w[i]);

        List<String> res = new ArrayList<>();
        helper(res, 0, m, "", price, new boolean[n + 1]);
        for(String s : res)
            System.out.println(s);
    }

    private static void helper(List<String> res, int index, int m, String str, int[] price, boolean[] visited){
        if(m <= 0){
            if(m == 0) {
                str = str.substring(0, str.length() - 1);
                res.add(str);
            }
            return;
        }

        for (int i = index; i < price.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(res, i, m - price[i], str + price[i] + ",", price, visited);
                visited[i] = false;
            }
        }
    }

}