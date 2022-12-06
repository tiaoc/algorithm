package com.lcp;

public class SG01 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int count = 0;
        for (int[] f : fruits) {
            int a = f[1] / limit;
            int b = f[1] % limit;
            if (b > 0) {
                a++;
            }
            count += a * time[f[0]];
        }
        return count;
    }
}
