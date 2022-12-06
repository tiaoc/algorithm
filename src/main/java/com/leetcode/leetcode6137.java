package com.leetcode;

public class leetcode6137 {

    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{4,4, 4, 5, 6}));
    }

    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 1; i < n; i++) {
            if (i > 1 && dp[i - 2] && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                dp[i + 1] = true;
            } else if (dp[i - 1] && nums[i] == nums[i - 1]) {
                dp[i + 1] = true;
            } else if (i > 1 && dp[i - 2] && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
                dp[i + 1] = true;
            }
        }
        return dp[n];
    }
}
