package com.leetcode;

import java.util.Arrays;

public class leetcode6160 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] pre = new int[nums.length + 1];
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            pre[j + 1] = pre[j] + nums[j];
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < pre.length; j++) {
                if (queries[i] < pre[j]) {
                    break;
                } else {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}