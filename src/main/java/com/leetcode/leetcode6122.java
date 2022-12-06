package com.leetcode;

import java.util.Arrays;

public class leetcode6122 {
    //删除nums中不能被divide整除的所有数字
    public int minOperations(int[] nums, int[] numsDivide) {
        int times = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                times++;
                continue;
            }
            int num = nums[i];
            boolean flag = false;
            for (int d : numsDivide) {
                if (d % num != 0) {
                    times++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return times;
            }
        }
        return -1;
    }
}
