package com.leetcode;

public class leetcode6125 {
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }
}
