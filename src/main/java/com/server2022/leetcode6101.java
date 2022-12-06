package com.server2022;

public class leetcode6101 {
    public static void main(String[] args) {
        System.out.println(checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
    }
    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0 || grid[i][n - i - 1] == 0) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || j == n - i - 1) {
                    continue;
                }
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
