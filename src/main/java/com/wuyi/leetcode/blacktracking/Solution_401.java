package com.wuyi.leetcode.blacktracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_401 {
    /**
     * 直接暴力解法
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int h = 0; h < 12; h++)
            for(int m = 0; m < 60; m++){
                if(bitCount(m) + bitCount(h) == num)
                    res.add(date(h, m));
            }

        return res;
    }

    private int bitCount(int m){
        int cnt = 0;
        while(m != 0){
            m = m & m - 1;
            cnt++;
        }
        return cnt;
    }

    private String date(int h, int m){
//        StringBuilder sb = new StringBuilder();
//        StringBuilder min = new StringBuilder();
//        sb.append(h + ":");
//        if(m < 10)
//            min.append(0);
//        min.append(m);
//        sb.append(min);
//        return sb.toString();

        return h + ":" + (m < 10 ? "0" + m : m);
    }


}
