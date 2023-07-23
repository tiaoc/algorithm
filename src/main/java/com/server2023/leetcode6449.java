package com.server2023;

public class leetcode6449 {
    // 最多旋转n次--向左旋转
    // 旋转i次后，nums[j]的成本是 nums[(j-i+n)%n] ,公有成本是i*x。
    // 状态转移， dp[i][j] = Math.min(dp[i-1][j], nums[(j-i+n)%n])
    // 公有成本如何核算，比如剩两格，成本是m，再旋转一次，成本为n<m。
    // 每旋转一次记录一下当前所有和。
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n + 1][n];
        long cost = 0;
        for (int j = 0; j < n; j++) {
            dp[0][j] = nums[j];
            cost += nums[j];
        }
        for (int i = 1; i < n; i++) {
            long tmp = (long) i * x;
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], nums[(j - i + n) % n]);
                tmp += dp[i][j];
            }
            cost = Math.min(cost, tmp);
        }
        return cost;
    }
}
