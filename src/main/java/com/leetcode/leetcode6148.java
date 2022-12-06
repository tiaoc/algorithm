package com.leetcode;

public class leetcode6148 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int num = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        num = Math.max(num, grid[x][y]);
                    }
                }
                res[i - 1][j - 1] = num;
            }
        }
        return res;
    }
}
