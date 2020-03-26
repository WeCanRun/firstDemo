package com.wuyi.leetcode.grandy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;



public class Solution_455 {

    public int findContentChildren1(int[] g, int[] s) {
        int gi, si;
        if ((gi = g.length) == 0 || (si = s.length) == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        while (gi > 0 && si > 0){
            if (s[si - 1] >= g[gi - 1]){
                res++;
                si--;
                gi--;
            } else
                gi--;
        }
        return res;
    }

    public int findContentChildren2(int[] g, int[] s) {
        int gn, sn;
        if ((gn = g.length) == 0 || (sn = s.length) == 0)
            return 0;

        //对基本数据类型数组的逆序排序
        s = IntStream.of(s).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        g = IntStream.of(g).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int res = 0, gi = 0, si = 0;
        while (gi < gn && si < sn){
            if (s[si] >= g[gi]){
                res++;
                si++;
                gi++;
            } else
                gi++;
        }
        return res;
    }


    public int findContentChildren3(int[] g, int[] s) {
        int gi, si;
        if ((gi = g.length) == 0 || (si = s.length) == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;
        while (gi > child && si > cookie){
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
