package com.wuyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        if(s.length <= 1 || s.length >= 1024){
            System.out.println(false);
            return;
        }
        StringBuilder temp = new StringBuilder();

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length; i++){
            char c = s[i].charAt(0);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);

            c = s[i].charAt(s[i].length() - 1);

            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);

        }
        boolean res = true;
        for (Map.Entry  m : map.entrySet()){
            if (map.size() != s.length || (Integer)m.getValue() != 2){
               res = false;
               break;
            }
        }

        System.out.println(res);
    }
}
