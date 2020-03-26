package com.wuyi.bishi.dianxinyunjisuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(";");
        Main_2 main = new Main_2();
        boolean res = main.answer(str[0], str[1]);
        if (res)
            System.out.println("True");
        else
            System.out.println("False");
    }

    private boolean answer(String s, String t){
        if(s.length() != t.length())
            return false;
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a) && map.get(a) != b)
                return false;
            map.put(a, b);
        }
        return true;
    }
}
