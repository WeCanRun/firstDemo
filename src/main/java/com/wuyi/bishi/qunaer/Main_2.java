package com.wuyi.bishi.qunaer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2 {
    private Map<Character,Integer> map;
    private StringBuilder res;

    public static void main(String[] args) {
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().trim();
        String back = sc.nextLine().trim();

        main.map = new HashMap<>();
        main.res = new StringBuilder();
        for (int i = 0; i < in.length(); i++)
            main.map.put(in.charAt(i), i);

        main.help(0, in.length() - 1, back.length() - 1, back.toCharArray());
        System.out.println(main.res);
    }

    private void help(int start, int end, int backR, char[] back){
        if (start > end)
            return;

        int index = map.get(back[end]);
        int rightSize = backR - index;
        //System.out.print(back[end]);
        res.append(back[end]);
        help(start, end - rightSize - 1, index - 1, back);
        help(end - rightSize, end - 1, backR, back);
    }
}
