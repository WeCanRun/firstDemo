package com.wuyi.leetcode.array;

public class Solution_75 {
    public void sortColors(int[] nums) {
        int zero = -1, two = nums.length;
        for(int i = 0; i < two ; ){
            if(nums[i] == 1)
                i++;
            else if(nums[i] == 0){
                zero++;
                swap(nums, zero, i++);
            } else{
                two--;
                swap(nums, two, i);
            }

        }
    }

    private void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        Solution_75 s = new Solution_75();
        int[] nums  = {2,0,2,1,1,0};
        s.sortColors(nums);
    }
}
