package com.leetcode;

import java.util.Arrays;

public class leetcode6136 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == diff) {
                    if (pre[j] != -1) {
                        count++;
                    }
                    pre[i] = j;
                    break;
                }
            }
        }
        return count;
    }
}
