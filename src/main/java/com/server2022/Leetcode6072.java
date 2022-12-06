package com.server2022;

public class Leetcode6072 {
    public static void main(String[] args) {
       // int[][] nums = new int[][]{{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}};
        int[][] nums = new int[][]{{3,3,5},{3,3,5},{2,2,10}};
        System.out.println(new Leetcode6072().maxTrailingZeros(nums));
    }

    // 5和2的匹配个数
    // 表格变为 5 2 1
    // 每个点纵向5和2，横向5和2（除去自身，或者只计算横、竖）
    // 3 3 5
    // 3 3 5
    // 2 2 10
//    public int maxTrailingZeros(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[][] twos = new int[m][n];
//        int[][] fives = new int[m][n];
//        int[][][] hl = new int[m][n + 1][2];
//        int[][][] lu = new int[m+1][n][2];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int temp = grid[i][j];
//                int two = 0, five = 0, t = 0;
//                while (temp % 2 == 0) {
//                    two++;
//                    temp /= 2;
//                }
//                while (temp % 5 == 0) {
//                    five++;
//                    temp /= 5;
//                }
//                twos[i][j] = two;
//                fives[i][j] = five;
//                hl[i][j + 1][0] = hl[i][j][0] + two;
//                hl[i][j + 1][1] = hl[i][j][1] + five;
//                lu[i+1][j][0] = lu[i][j][0] +two;
//                lu[i+1][j][1] = lu[i][j][1] +five;
//            }
//        }
//        for (int i = m-1; i >=0; i--) {
//
//        }
//        int couple = 0;
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < m; i++) {
//                couple = Math.max(couple,Math.min(hl[i][j + 1][0]+, hl[i][j + 1][1]));
//                couple  = Math.max(couple,Math.min(hl[i][n][0]-hl[i][j + 1][0], hl[i][n][1]-hl[i][j + 1][1]));
//                couple  = Math.max(couple, Math.min())
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            int two = 0, five = 0;
//            for (int i = m - 1; i >= 0; i--) {
//                int temp2, temp5;
//                if (Math.min(hl[i][j + 1][0], hl[i][j + 1][1]) >
//                        Math.min(hr[i][j][0], hr[i][j][1])) {
//                    temp2 = hl[i][j + 1][0];
//                    temp5 = hl[i][j + 1][1];
//                } else {
//                    temp2 = hr[i][j][0];
//                    temp5 = hr[i][j][1];
//                }
//                couple = Math.max(couple, Math.min(two + temp2, five + temp5));
//                two += twos[i][j];
//                five += fives[i][j];
//            }
//        }
//        return couple;
//    }
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] twos = new int[m][n];
        int[][] fives = new int[m][n];
        int[][][] horizontalLeft = new int[m][n + 1][2];
        int[][][] horizontalRight = new int[m][n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = grid[i][j];
                int two = 0, five = 0;
                while (temp % 2 == 0) {
                    two++;
                    temp /= 2;
                }
                while (temp % 5 == 0) {
                    five++;
                    temp /= 5;
                }
                twos[i][j] = two;
                fives[i][j] = five;
                horizontalLeft[i][j + 1][0] = horizontalLeft[i][j][0] + two;
                horizontalLeft[i][j + 1][1] = horizontalLeft[i][j][1] + five;
            }
            for (int j = n - 1; j >= 0; j--) {
                int two = twos[i][j], five = fives[i][j];
                horizontalRight[i][j][0] = horizontalRight[i][j + 1][0] + two;
                horizontalRight[i][j][1] = horizontalRight[i][j + 1][1] + five;
            }
        }
        int couple = 0;
        for (int j = 0; j < n; j++) {
            int two = 0, five = 0;
            for (int i = 0; i < m; i++) {
                couple = Math.max(couple, Math.max(Math.min(two+horizontalLeft[i][j + 1][0],
                        five+horizontalLeft[i][j + 1][1]), Math.min(two+horizontalRight[i][j][0], five+horizontalRight[i][j][1])));
                two += twos[i][j];
                five += fives[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            int two = 0, five = 0;
            for (int i = m - 1; i >= 0; i--) {
                int temp2, temp5;
                if (Math.min(horizontalLeft[i][j + 1][0], horizontalLeft[i][j + 1][1]) >
                        Math.min(horizontalRight[i][j][0], horizontalRight[i][j][1])) {
                    temp2 = horizontalLeft[i][j + 1][0];
                    temp5 = horizontalLeft[i][j + 1][1];
                } else {
                    temp2 = horizontalRight[i][j][0];
                    temp5 = horizontalRight[i][j][1];
                }
                couple = Math.max(couple, Math.min(two + temp2, five + temp5));
                two += twos[i][j];
                five += fives[i][j];
            }
        }
        return (int) couple;
    }
}
