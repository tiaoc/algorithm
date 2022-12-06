package com.leetcode;

public class leetcode1155 {
    // 和=target
    public static void main(String[] args) {
        System.out.println(new leetcode1155().numRollsToTarget(2, 6, 7));
    }

    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < target; j++) {
                for (int m = 1; m <= k && j + m <= target; m++) {
                    dp[i][j + m] = (dp[i][j + m] + dp[i - 1][j]) % mod;
                }
            }
        }
        return dp[n][target];
    }
}
