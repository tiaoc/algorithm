package com.leetcode;

import java.util.Arrays;

public class leetcode6132 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        boolean f = true;
        int count = 0;
        while (f) {
            int c = 0;
            f = false;
            for (int i = 0; i < nums.length; i++) {
                if (c == 0 && nums[i] > 0) {
                    c = nums[i];
                    nums[i] = 0;
                    f = true;
                } else if (nums[i] > 0) {
                    nums[i] -= c;
                    f = true;
                }
            }
            if (f) {
                count++;
            }
        }
        return count;
    }
}
