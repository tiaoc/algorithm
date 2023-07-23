package com.server2023;

import java.util.Arrays;

public class leetcode6355 {
    public static void main(String[] args) {
        System.out.println(new leetcode6355().countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    // 相加和在区间之间，i<j
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] + nums[i] < lower) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int a = left;
            left = i + 1;
            right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] + nums[i] > upper) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int b = left;
            res += b - a;
        }
        return res;
    }

    public long countFairPairs2(int[] nums, int lower, int upper) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int v = nums[i] + nums[j];
                if (v >= lower && v <= upper) {
                    res++;
                }
            }
        }
        return res;
    }
}
