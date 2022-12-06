package com.leetcode;

import java.util.Arrays;

public class leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount; j++) {
                if (j + coins[i] <= amount) {
                    dp[j + coins[i]] += dp[j];
                }
            }
        }
        return dp[amount];
    }
}
