package com.leetcode;

import java.util.Arrays;

public class leetcode518coins2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2};
        System.out.println(change(amount, coins));
    }
//硬币方法数-》+=
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
}
