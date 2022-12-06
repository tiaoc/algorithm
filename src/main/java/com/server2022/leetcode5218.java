package com.server2022;

import java.util.Arrays;

public class leetcode5218 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = k; i <= num; i += 10) {
            if (i == 0) {
                continue;
            }
            dp[i] = Math.min(dp[i], 1);
            for (int j = 2; i * j <= num; j++) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + j - 1);
            }
        }
        for (int i = 1; i <= num / 2; i++) {
            if (dp[i] < Integer.MAX_VALUE && dp[num - i] < Integer.MAX_VALUE) {
                dp[num] = Math.min(dp[i] + dp[num - i], dp[num]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[num] <Integer.MAX_VALUE ? dp[num] : -1;
    }
}
