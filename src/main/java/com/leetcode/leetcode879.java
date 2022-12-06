package com.leetcode;

import java.util.Arrays;

public class leetcode879 {
    //第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与
    // 利润和人员限制
    // 已使用的人员是条件，利润也是条件
    // 不是求最大利润，而是求min利润的组合数
    // 组合数是数组中存放的数据
    //
    public static void main(String[] args) {
        System.out.println(new leetcode879().profitableSchemes2(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][group.length + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int j = 0; j < group.length; j++) {
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (i < group[j]) {
                        dp[i][j + 1][k] = dp[i][j][k];
                    } else {
                        dp[i][j + 1][k] = (dp[i][j][k] + dp[i - group[j]][j][Math.max(0, k - profit[j])]) % mod;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[i][group.length][minProfit]) % mod;
        }
        return sum;
    }


    // 存组合数
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1000000007;
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (group[i - 1] > j) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % mod;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[group.length][i][minProfit]) % mod;
        }
        return sum;
    }
}
