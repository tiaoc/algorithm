package com.server2023;

public class leetcode6291 {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int n = 0;
        for (int v : nums) {
            sum += v;
            int t = v;
            while (t > 0) {
                int l = t % 10;
                t /= 10;
                n += l;
            }
        }
        return Math.abs(sum - n);
    }
}
