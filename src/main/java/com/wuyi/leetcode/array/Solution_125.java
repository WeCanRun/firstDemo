package com.wuyi.leetcode.array;

public class Solution_125 {
    private boolean isValid(char c){
        return c >= '0' && c < '9' || c > 'a' && c < 'z';
    }

    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        System.out.println(s);
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(!isValid(s.charAt(i))) i++;
            while(!isValid(s.charAt(j))) j--;

            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_125 s = new Solution_125();
        boolean res = s.isPalindrome("al a");
        System.out.println(res);
    }
}
