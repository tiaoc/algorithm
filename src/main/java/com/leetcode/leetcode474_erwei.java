package com.leetcode;

import java.util.Arrays;

public class leetcode474_erwei {
    public static void main(String[] args) {
        System.out.println(new leetcode474_erwei().findMaxForm(new String[]{
                "10", "0001", "111001", "1", "0"
        }, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int z = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    z++;
                }
            }
            int o = strs[i].length() - z;
            for (int j = m - z; j >= 0; j--) {
                for (int k = n - o; k >= 0; k--) {
                    dp[j + z][k + o] = Math.max(dp[j + z][k + o], dp[j][k] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
