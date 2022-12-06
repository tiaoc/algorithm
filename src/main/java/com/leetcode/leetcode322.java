package com.leetcode;

import java.util.Arrays;

public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + coins[i] <= amount && coins[i] <= amount) {
                    dp[j + coins[i]] = Math.min(dp[j + coins[i]], dp[j] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
