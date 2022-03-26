package com.leetcode;

public class leetcode5996 {

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
