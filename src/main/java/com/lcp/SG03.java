package com.lcp;

public class SG03 {
    // 一个点到下一个点的时间，吃不吃当前点,留下来的空闲时间，敲击后空闲时间清零
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1,0},{2,0,1},{4,2,2}};
        System.out.println(new SG03().getMaximumNumber(nums));
    }
    public int getMaximumNumber(int[][] moles) {
        int n = moles.length;
        int[][] dp = new int[n][8];
        int count=0;
        for (int i = 1; i < n; i++) {
            int gap = moles[i][1] - moles[i - 1][1] + moles[i][2] - moles[i - 1][2];
            int time = moles[i][0] - moles[i - 1][0];
            time = Math.min(time, 8);
            for (int j = Math.max(gap - time, 0); j < i && j < 8; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][j] + 1);
            }
            for (int j = 1; j < i && j < 8; j++) {
                int idx = Math.max(j - time, 0);
                dp[i][j] = dp[i - 1][idx];
            }
            count=Math.max(count, dp[i][0]);
        }
        return count;
    }
}