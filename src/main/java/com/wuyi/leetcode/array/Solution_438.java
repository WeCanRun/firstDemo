package com.wuyi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int[] window = new int[128];
        int l = 0, r = 0;
        int count = p.length();
        for(int i = 0; i < count; i++)
            window[p.charAt(i)]++;

        while(r < s.length()){
            System.out.println("count: " + count);
            System.out.println("l: " + l + " r: " + r);

            if(window[s.charAt(r++)]-- >= 1)
                count--;

            if(count == 0)
                res.add(l);

            if((r - l) == p.length() && window[s.charAt(l++)]++ >= 0) {
                count++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution_438 s = new Solution_438();
        List<Integer> res = s.findAnagrams("abcabcbb", "abc");
        System.out.println(res);
    }
}
