package com.wuyi.bishi.yongyou;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Map<Character,Integer> map;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        String pre = str[0];
        String in = str[1];
        main.map = new HashMap<>();
        for (int i = 0; i < in.length(); i++)
            main.map.put(in.charAt(i), i);

        main.help(0, in.length() - 1, 0, pre.toCharArray());
    }

    private void help(int start, int end, int inL, char[] pre){
        if (start > end)
            return;

        int index = map.get(pre[start]);
        int leftSize = index - inL;
        help(start + 1, start + leftSize, inL, pre);
        help(start + leftSize + 1, end, index + 1, pre);
        System.out.print(pre[start]);
    }
}
