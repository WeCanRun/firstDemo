package com.wuyi.leetcode.dp;

import java.util.HashSet;
import java.util.List;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        HashSet<String> set = new HashSet<>();

        for (String word : wordDict)
            set.add(word);

        dp[0] = true;
        for (int r = 1; r <= s.length(); r++)
            for (int l = 0; l < r; l++){
                if (dp[l] && set.contains(s.substring(l, r))){
                    dp[r] = true;
                    break;
                }

            }
        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
