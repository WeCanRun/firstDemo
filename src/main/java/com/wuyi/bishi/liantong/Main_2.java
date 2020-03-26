package com.wuyi.bishi.liantong;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        sc.close();
        double remain = Double.parseDouble(str[1]) - Double.parseDouble(str[0]);
        StringBuilder res = new StringBuilder();
        res.append(remain);
        res.append(" ");
        double[] lq = {50, 10, 5, 1, 0.5};
        int k = 0;
        while(remain != 0){
            for(; k < lq.length; k++){
                int num = (int) (remain / lq[k]);
                if(num == 0)
                    continue;
                remain -= num * lq[k];
                res.append((int)lq[k]);
                res.append(":");
                res.append(num);
                res.append(";");
            }
        }
        System.out.println(res.toString());
    }
}