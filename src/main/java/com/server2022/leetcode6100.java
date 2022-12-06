package com.server2022;

public class leetcode6100 {
    public static void main(String[] args) {
        System.out.println(countHousePlacements(806));
    }

    //同侧不能相邻，产生的左右可添加， 1 不添加 2.一侧添加*2 3 两侧添加
    public static int countHousePlacements(int n) {
        int mod = 1000000007;
        long[][] dp = new long[n][3];
        dp[0] = new long[]{1, 2, 1};
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % mod;
            dp[i][2] = dp[i - 1][0] % mod;
        }
        int res = (int) ((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % mod);
        return res;
    }
}
