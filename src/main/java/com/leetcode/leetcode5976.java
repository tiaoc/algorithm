package com.leetcode;

import java.util.HashSet;

public class leetcode5976 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (set.contains(matrix[i][j]) || matrix[i][j] < 1 || matrix[i][j] > n) {
                    return false;
                }
                set.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (set.contains(matrix[j][i]) || matrix[j][i] < 1 || matrix[j][i] > n) {
                    return false;
                }
                set.add(matrix[j][i]);
            }
        }
        return true;
    }
}
