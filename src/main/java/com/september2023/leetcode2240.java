package com.september2023;

import java.util.Arrays;

public class leetcode2240 {
    // 要么多买a，要么多买b。
    // 某个价格下能买的a和b方案数是固定的，不依赖其他。
    // 如果依赖状态转移，3,4 -> 4,4 3,5  4,3->4,4 5,3，可能出现重复状态数
    // 数组表示恰好用掉多少钱？
    // 状态表示f[i][j]：表示从前 i 件物品中选总体积不超过 j 的选法集合的数量。
    // 状态计算：f[i][j]=sum(f[i-1][j],f[i][j-v[i]])。
    public static void main(String[] args) {
        System.out.println(new leetcode2240().waysToBuyPensPencils(20, 10, 5));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long[][] dp = new long[3][total + 1];
        Arrays.fill(dp[0], 1);
        int[] cost = new int[]{cost1, cost2};
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= cost[i - 1]) {
                    dp[i][j] += dp[i][j - cost[i - 1]];
                }
            }
        }
        return dp[2][total];
    }
}
