package com.wuyi.bishi.VIPKID;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(",\\s+");
        long[] arr = new long[str.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Long.parseLong(str[i]);
        int res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1])
                    continue;
                if (arr[i] + arr[j] == 0)
                    res++;
            }
        }
        System.out.println(res);
    }
}
