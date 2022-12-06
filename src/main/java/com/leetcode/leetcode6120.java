package com.leetcode;

public class leetcode6120 {
    public int[] numberOfPairs(int[] nums) {
        int pair = 0, sin = 0;
        boolean[] arr = new boolean[101];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]]) {
                pair++;
            }
            arr[nums[i]] = !arr[nums[i]];
        }
        for (int i = 0; i < 101; i++) {
            if (arr[i]) {
                sin++;
            }
        }
        return new int[]{pair, sin};
    }
}
