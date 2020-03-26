package com.wuyi.leetcode.array;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return -1;

        return partion(nums, k , 0, nums.length - 1);
    }

    private int partion(int[] nums, int k, int l, int r) {
        int target = nums[l];
        int i = l + 1, j = r;
        while (true) {
            while (i < r && nums[i] >= target)
                i++;
            while (j > l && nums[j] <= target)
                j--;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);

        if (j == k - 1) return target;
        else if (j < k) return partion(nums, k, j + 1, r);
        else return partion(nums, k, l , j - 1);

    }

    private void printArray(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j )
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        if(k > nums.length)
            return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0 ; i < nums.length; i++){
            if(i >= k && minHeap.peek() < nums[i]){
                minHeap.poll();
                System.out.println("build: "+ minHeap);
            }
            if (minHeap.size() < k)
                minHeap.add(nums[i]);
        }
        System.out.println(minHeap);
        return minHeap.poll();
    }

    public static void main(String[] args) {
        Solution_215 s = new Solution_215();
        int[] nums = {3, 2, 1, 5, 6, 4, 83, 3};
        int res = s.findKthLargest2(nums, 5);
        System.out.println(res);
    }

}
