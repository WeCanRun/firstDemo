package com.wuyi.leetcode.blacktracking;

public class Solution_9 {

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int div = 1;
        while(x / div >= 10)
            div *= 10;
        System.out.println("div: " + div);
        while(x > 0){
            int l = x / div;
            int r = x % 10;
            if (l != r)
                return  false;

            x = (x % div) / 10;
            System.out.println("x: " + x);
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_9 s = new Solution_9();
        boolean res = s.isPalindrome(121);
        System.out.println(res);
    }
}
