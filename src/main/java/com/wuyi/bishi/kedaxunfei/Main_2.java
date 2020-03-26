package com.wuyi.bishi.kedaxunfei;

import java.util.Scanner;

public class Main_2 {

    private static int helper(int[] a, int l, int r, int key){
        if (l > r)
            return -2;

        System.out.println("l: " + l);
        System.out.println("r: " + r);
        int mid = l + (r - l) / 2;
        System.out.println("mid: " + mid);
        System.out.println(a[mid] == key);
        if (a[mid] == key)
            return mid;

        else if (a[mid] < key)
            return helper(a, mid + 1, r, key);
        else
            return helper(a, l, mid - 1, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] array = str.substring(1, str.length() - 1).split(",");

        int[] a = new int[array.length];
        for (int i = 0; i < array.length; i++){
            //System.out.println(array[i]);
            a[i] = Integer.parseInt(array[i]);
        }

        int res = helper(a, 0, a.length, 19);
        System.out.println(res + 1);
    }
}
