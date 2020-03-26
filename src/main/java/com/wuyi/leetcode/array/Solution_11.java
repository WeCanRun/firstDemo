package com.wuyi.leetcode.array;

public class Solution_11 {
    public int maxArea(int[] height) {
        int n = height.length;
        if(n < 2)
            return 0;

        int max = Integer.MIN_VALUE;
        int i = 0, j = n - 1;
        while(i < j){
            if(height[i] < height[j]){
                max = Math.max(max, height[i] * (j - i));
                i++;
            }else{
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_11 s = new Solution_11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        s.maxArea(height);
        boolean contains = "ab".contains("ba");
        System.out.println(contains);
    }
}
