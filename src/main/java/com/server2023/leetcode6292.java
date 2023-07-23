package com.server2023;

import java.util.Arrays;

public class leetcode6292 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        int[][] res = new int[n][n];
        for (int[] q : queries) {
            diff[q[0]][q[1]]++;
            diff[q[0]][q[3] + 1]--;
            diff[q[2] + 1][q[1]]--;
            diff[q[2] + 1][q[3] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = Arrays.copyOf(diff[i], n);
        }
        return res;
    }


    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }
}
