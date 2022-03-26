package com.leetcode;

import java.util.Arrays;

public class leetcode6029 {
    // alice 基准线，获得每个分的基准线
    //
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0})));
        //System.out.println(maximumBobPoints(3, new int[]{0,0,1,0,0,0,0,0,0,0,0,2}));
    }

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int[][] dp = new int[n][numArrows + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < numArrows + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                if (j > aliceArrows[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - aliceArrows[i] - 1] + i);
                }
            }
        }
        int[] res = new int[n];
        int j = numArrows;
        for (int i = n - 1; i > 0; i--) {
            if (dp[i][j] == dp[i - 1][j]) {
                continue;
            }
            if (dp[i][j] == dp[i - 1][j - aliceArrows[i] - 1] + i) {
                res[i] = aliceArrows[i] + 1;
                j -= aliceArrows[i] + 1;
            }
        }
        res[0] = j;
        return res;
    }
}
