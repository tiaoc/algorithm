package com.server2022;

public class leetcode6080 {
    // 某个数后面跟着的小于它的数要删几次，它自己会不会被删
    // 计算某个数的删除时间，遇到什么数字 重新计时
    //
    public int totalSteps(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                continue;
            }

        }
        return 0;
    }
}
