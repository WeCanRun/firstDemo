package com.wuyi.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution_290 s = new Solution_290();
        boolean b = s.wordPattern("abcab", "a dog cat a dog");
        System.out.println(b);
    }
}
