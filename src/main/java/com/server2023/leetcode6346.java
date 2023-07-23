package com.server2023;

import java.util.Arrays;

public class leetcode6346 {
    public static void main(String[] args) {
        System.out.println(new leetcode6346().minCapability(new int[]{4, 22, 11, 14, 25}, 3));
    }

    // dp 前二 前三
    // dp[i][j] = Math.min(Math.max(dp[i-2][j-1],nums[i]), dp[i-1][j])
    public int minCapability(int[] nums, int k) {
        int left = 0, right = Arrays.stream(nums).max().getAsInt();
        while (left <= right) {
            int mid = (right + left) / 2;
            if (check(nums, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int max) {
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                dp0 = dp1;
            } else {
                int temp = dp1;
                dp1 = Math.max(dp1, dp0 + 1);
                dp0 = temp;
            }
            if (dp1 >= k) {
                return true;
            }
        }
        return dp1 >= k;
    }
}
