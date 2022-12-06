package com.server2022;

import java.util.Arrays;

public class Leetcode6034 {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        dp[n - 1] = Arrays.copyOf(nums, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                dp[i][j] = (dp[i + 1][j] + dp[i + 1][j + 1]) % 10;
            }
        }
        return dp[0][0];
    }
}
