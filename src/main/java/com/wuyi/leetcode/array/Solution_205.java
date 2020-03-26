package com.wuyi.leetcode.array;

public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {

        char[] help = new char[128];
        for(int i = 0; i < s.length();i++){
            int index = s.charAt(i);
            if(help[index] != 0 && help[index] != t.charAt(i))
                return false;
            if(help[index] == 0 &&  contains(help, t.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean contains(char[] arr, char c){
        for(char a : arr)
            if(a == c)
                return true;
        return false;
    }

    public static void main(String[] args) {
        Solution_205 s = new Solution_205();
        boolean res = s.isIsomorphic("13", "42");
        System.out.println(res);
    }
}
