package com.wuyi.leetcode.dp;

public class Solution_376 {

    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++)
            for (int j = i; j >= 0; j--)
                if (nums[i] > nums[j])
                    up[i] = Math.max(up[i], down[j] + 1);
                else if(nums[i] < nums[j])
                    down[i] = Math.max(down[i], up[j] + 1);
        print(up);
        print(down);
        return Math.max(down[n - 1], up[n - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i - 1]){
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]){
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        print(up);
        print(down);
        return Math.max(down[n - 1], up[n - 1]);
    }

    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int up = 1, down = 1;

        for (int i = 1; i < n; i++)
            if (nums[i] > nums[i - 1])
                up = down + 1;
             else if (nums[i] < nums[i - 1])
                down = up + 1;

        return Math.max(down, up);
    }

    private void print(int[] nums){
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution_376 s = new Solution_376();
        int[] nums = {1, 7, 4, 9, 2, 5};
        s.wiggleMaxLength1(nums);
        int res = s.wiggleMaxLength3(nums);
        System.out.println(res);
    }
}
