package com.wuyi.bishi.youzan;

import java.util.HashMap;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine().trim();
        String B = sc.nextLine().trim();
        HashMap<String, Integer> map = new HashMap<>();
        int k = B.length();
        if(A.length() >= k) {
            for (int i = 0; i <= A.length() - k; i++) {
                String subStr = A.substring(i, i + k);
                if (map.containsKey(subStr))
                    map.put(subStr, map.get(subStr) + 1);
                else
                    map.put(subStr, 1);
            }
        }
        System.out.println(map.getOrDefault(B, 0));
    }
}
