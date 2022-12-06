package com.server2022;

public class leetcode6053 {
    public static void main(String[] args) {
        int[][] g = new int[][]{{0, 0}, {1, 1}, {2, 3}};
        int[][] w = new int[][]{{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguarded(4, 6, g, w));
    }

    //被看守用1表示，没被看守用0
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        byte[][] map = new byte[m][n];
        for (int[] w : walls) {
            map[w[0]][w[1]] = 2;
        }
        for (int[] g : guards) {
            map[g[0]][g[1]] = 3;
        }
        for (int[] g : guards) {
            int x = g[0], y = g[1], left = g[0] - 1, right = g[1] - 1;
            while (left >= 0) {
                int v = map[left][y];
                if (v == 3 || v == 2) {
                    break;
                }
                map[left][y] = 1;
                left--;
            }
            left = g[0] + 1;
            while (left < m) {
                int v = map[left][y];
                if (v == 3 || v == 2) {
                    break;
                }
                map[left][y] = 1;
                left++;
            }
            while (right >= 0) {
                int v = map[x][right];
                if (v == 3 || v == 2) {
                    break;
                }
                map[x][right] = 1;
                right--;
            }
            right = g[1] + 1;
            while (right < n) {
                int v = map[x][right];
                if (v == 3 || v == 2) {
                    break;
                }
                map[x][right] = 1;
                right++;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
