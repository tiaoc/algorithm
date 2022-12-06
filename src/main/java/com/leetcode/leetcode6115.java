package com.leetcode;

public class leetcode6115 {
    public static void main(String[] args) {
        System.out.println(idealArrays(9767, 9557));
    }

    //https://www.bilibili.com/video/BV1we4y1R7ZG?vd_source=2b856b7f53afc4c50b68191d31b489e3
    public static int idealArrays(int n, int m) {
        int mod = 1000000007;
        int[][] f = new int[m + 1][15];
        for (int i = 1; i <= m; i++) {
            f[i][1] = 1;
        }
        for (int j = 1; j < 14; j++) {
            for (int i = 1; i <= m; i++) {
                for (int k = 2; k * i <= m; k++) {
                    f[k * i][j + 1] = (f[k * i][j + 1] + f[i][j]) % mod;
                }
            }
        }
        int[][] arr = new int[n][15];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i && j <= 14; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 14 && j <= n; j++) {
                res = (int) ((res + (long) f[i][j] * arr[n - 1][j - 1]) % mod);
            }
        }
        return res;
    }
}
