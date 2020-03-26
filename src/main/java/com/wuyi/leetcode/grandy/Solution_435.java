package com.wuyi.leetcode.grandy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_435 {
    public int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals.length == 0)
            return 0;

        Integer[][] nums = new Integer[intervals.length][intervals[0].length];
        for (int i = 0; i < intervals.length; i++)
            for (int j = 0; j < intervals[0].length; j++)
                nums[i][j] = intervals[i][j];

        Arrays.sort(nums, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int pre = 0, res = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i][0] >= nums[pre][1]){
                res++;
                pre = i;
            }
        }

        return nums.length - res;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        if(intervals.length == 0)
            return 0;

        Integer[][] nums = new Integer[intervals.length][intervals[0].length];
        for (int i = 0; i < intervals.length; i++)
            for (int j = 0; j < intervals[0].length; j++)
                nums[i][j] = intervals[i][j];

        Arrays.sort(nums, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j <= i; j++)
            if(nums[i][0] >= nums[j][1]){
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp)
            max = Math.max(num, max);

        return nums.length - max;
    }

    public static void main(String[] args) {
        Solution_435 s = new Solution_435();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int res = s.eraseOverlapIntervals1(intervals);
        System.out.println(res);
    }
}
