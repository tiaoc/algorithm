package com.leetcode;

public class leetcode48 {
    // 00-> 0 n-1  01 ->n-1,1  4,0-> 4,4  2,1 -> 1,1
    // a,b-> b,n-1-a
    // matrix[row][col]->matrix[]
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new leetcode48().rotate(a);
        System.out.println(a);
    }

    // 求的是x,y, 就去看行和列是怎么换的
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
