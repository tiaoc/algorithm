package com.leetcode;

import java.util.Arrays;

public class leetcode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    //爬楼梯方法数
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
