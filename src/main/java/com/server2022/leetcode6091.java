package com.server2022;

import java.util.Arrays;

public class leetcode6091 {
    //差值小于等于k
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1, cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur + k) {
                count++;
                cur = nums[i];
            }
        }
        return count;
    }
}
