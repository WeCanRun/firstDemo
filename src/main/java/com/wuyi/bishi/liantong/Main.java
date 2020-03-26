package com.wuyi.bishi.liantong;

import java.util.*;

public class Main{
    private List<String> res = new ArrayList();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();

        Main main = new Main();
        main.helper(0, src, "");
        for(String s : main.res)
            System.out.print(s + " ");
        System.out.println();
    }

    private void helper(int index, String src, String str){
        if(index == src.length()){
            res.add(str);
            return;
        }

        for (int j = 1; j <= 3; ++j)
            helper(index + 1, src, str + src.charAt(index) + j);

    }
}