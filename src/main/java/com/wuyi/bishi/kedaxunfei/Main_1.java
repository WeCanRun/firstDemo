package com.wuyi.bishi.kedaxunfei;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1 {
    private static boolean isNum(char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            LinkedList<String> res = new LinkedList<>();
            for (int i = 0; i < str.length(); i++){
                if (isNum(str.charAt(i)))
                    res.add(str.substring(i, i+1));
            }
            if (!res.isEmpty()){
                Collections.sort(res);
                while (!res.isEmpty()){
                    System.out.print(res.removeFirst());
                }
                System.out.println();
            } else
                System.out.println(-1);
        }

    }

}
