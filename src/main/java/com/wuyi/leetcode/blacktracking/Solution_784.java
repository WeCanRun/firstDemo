package com.wuyi.leetcode.blacktracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_784 {
    private int len;
    private List<String> res;

    private boolean isLetter(char c){
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122)
            return true;
        return false;
    }

    public List<String> letterCasePermutation(String S) {
        len = S.length();
        res = new ArrayList<>();
        if (len == 0)
            return res;
        helper(S.toCharArray(), 0);
        return res;
    }



    private void helper(char[] src, int index) {
        if (index == len) {
            res.add(String.valueOf(src));
            return;
        }

        helper(src, index + 1);
        if (isLetter(src[index])) {
            src[index] ^= (1 << 5);
            helper(src, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution_784 s = new Solution_784();
        s.letterCasePermutation("3z4");
        System.out.println(s.res);
    }
}
