package com.leetcode;

import java.util.Arrays;

public class leetcode312 {
    //戳出来是乘
    //
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = arr[n + 1] = 1;
        int[][] rec = new int[n + 2][n + 2];
        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i], -1);
        }
        return find(rec, arr, 0, n + 1);
    }

    // 0 1 2
    // l r
    // l = r - 1 ,l和r之间没有数字，但循环从left+1开始 所以这个数字没遍历到。它会等于0而不是-1。
    // 实际上不存在l=r-1的情况，中间必须有气球。
    // 实际上-1表示没遍历到，0是正常状态。任何其他状态都比它大。
    private int find(int[][] rec, int[] arr, int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, arr[left] * arr[right] * arr[i] + find(rec, arr, left, i) + find(rec, arr, i, right));
        }
        rec[left][right] = res;
        return res;
    }

    public int maxCoinsDp(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = arr[n + 1] = 1;
        int[][] rec = new int[n + 2][n + 2];
        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i], -1);
        }
        for (int i = n + 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    rec[i][j] = Math.max(rec[i][k] + rec[k][j] + arr[i] * arr[k] * arr[j], rec[i][j]);
                }
            }
        }
        return rec[0][n + 1];
    }
}
