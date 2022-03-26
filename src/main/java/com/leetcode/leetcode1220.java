package com.leetcode;

import java.util.Arrays;

public class leetcode1220 {
    //限定长度，根据条件，状态转移
    //1-2-3-4
    //往前面添加
    public int countVowelPermutation(int n) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = ((dp[i - 1][0] + dp[i - 1][1]) % mod + (dp[i - 1][3] + dp[i - 1][4]) % mod) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][4] = dp[i - 1][0] % mod;
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res = (res + dp[n - 1][i]) % mod;
        }
        return res;
    }
}
