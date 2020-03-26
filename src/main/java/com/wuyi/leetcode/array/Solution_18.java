package com.wuyi.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 4)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++ ){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1;j < n; j++ ){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                while(l < r){
                    int temp = nums[l] + nums[r] + nums[i] + nums[j];
                    if(temp == target){
                        res.add(Arrays.asList( nums[i], nums[j],nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if(temp > target)
                        r--;
                    else
                        l++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_18 s = new Solution_18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = s.fourSum(nums, 0);
        System.out.println(res);
    }
}
