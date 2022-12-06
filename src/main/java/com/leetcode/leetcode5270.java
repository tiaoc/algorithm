package com.leetcode;

import java.util.Arrays;

public class leetcode5270 {
    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(minPathCost(grid, moveCost));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[m * n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int node : grid[0]) {
            dp[node] = 0;
        }
        for (int i = 0; i < grid.length; i++) {
            if (i == m - 1) {
                break;
            }
            for (int node : grid[i]) {
                for (int j = 0; j < n; j++) {
                    int nextNode = grid[i + 1][j];
                    dp[nextNode] = Math.min(dp[nextNode], dp[node] + moveCost[node][j] + node);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int node : grid[m - 1]) {
            res = Math.min(res, dp[node] + node);
        }
        return res;
    }
}
