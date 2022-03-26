package com.leetcode;

import java.util.Arrays;

public class leetcode5989 {
    public static void main(String[] args) {
        int[] n = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(new leetcode5989().countElements(n));
    }

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0], max = nums[nums.length - 1];
        int minIdx = 0, maxIdx = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != min) {
                minIdx = i - 1;
                break;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != max) {
                maxIdx = i + 1;
                break;
            }
        }
        if (nums[0] == nums[nums.length - 1]) {
            return 0;
        }
        if (minIdx < maxIdx) {
            return maxIdx - minIdx - 1;
        }
        return 0;
    }
}
