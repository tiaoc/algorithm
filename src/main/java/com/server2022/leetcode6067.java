package com.server2022;

public class leetcode6067 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] leftSum = new long[n + 1];
        long[] rightSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftSum[i + 1] >= rightSum[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
