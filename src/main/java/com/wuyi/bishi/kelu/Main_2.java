package com.wuyi.bishi.kelu;

import java.util.*;

public class Main_2 {
    public static String solution(String longString, String alphabet) {
        //代码写这里
        String res = "";
        int min = Integer.MAX_VALUE;
        int i = 0, j = 1;
        boolean flag = false;
        while (j <= longString.length() && !flag) {
            flag = true;
            while (j < longString.length() && !contains(longString.substring(i, j), alphabet)){
                j++;
                flag = false;
            }

            while (i < j  && contains(longString.substring(i, j), alphabet)){
                i++;
                flag = false;
            }

            if(min > j - i){
                res = longString.substring(i - 1, j);
                min = j - i;
            }
        }

        return res;
    }

    private static boolean contains(String str, String apl) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray())
            set.add(c);

        for (int i = 0; i < apl.length(); i++)
            if (!set.contains(apl.charAt(i)))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String longString = in.next();
        String alphabet = in.next();
        System.out.println(solution(longString, alphabet));

    }
}