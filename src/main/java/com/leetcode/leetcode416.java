package com.leetcode;

import java.util.Arrays;

public class leetcode416 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] == target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][target];
    }


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2, n = nums.length;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = half - 1; j >= 0; j--) {
                if (dp[j] && j + nums[i] <= half) {
                    dp[j + nums[i]] = true;
                }
            }
        }
        return dp[half];
    }

}
