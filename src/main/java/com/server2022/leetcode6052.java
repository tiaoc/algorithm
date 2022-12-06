package com.server2022;

import java.util.Arrays;

public class leetcode6052 {
    public int minimumAverageDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        long left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            sum -= nums[i];
            int a = (int) (left / (i + 1));
            int b = 0;
            if (nums.length != i + 1) {
                b = (int) (sum / (nums.length - i - 1));
            }
            int v = Math.abs(a - b);
            if (v < min) {
                min = v;
                idx = i;
            }
        }
        return idx;
    }
}
