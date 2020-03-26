package com.wuyi.leetcode.array;

public class Solution_88 {

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0)
            return;
        int i = 0, j = 0, k = 0;
        for (i = m - 1; i >= 0; i--)
            nums1[i + n] = nums1[i];
        i = n;
        for (; i < n + m && j < n; k++) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums1[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }

        while(j < n){
            nums1[k++] = nums2[j++];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[m + n];
        int i = 0, j = 0;
        for (int k = 0; k < help.length; k++) {
            if (j == n || i < m && nums1[i] <= nums2[j])
                help[k] = nums1[i++];
            else
                help[k] = nums2[j++];
        }

        for (int k = 0; k < help.length; k++)
            nums1[k] = help[k];
    }


    public static void main(String[] args) {
        Solution_88 s = new Solution_88();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        s.merge2(nums1, 1, nums2, 1);

        for (int num : nums1)
            System.out.print(num + " ");
    }

}
