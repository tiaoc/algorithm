package com.leetcode;

import java.util.Arrays;

public class leetcode6017 {
    // 等差数列的和 减去空缺数字
    // 找1-k中重合了几个，重合的话，右边界继续扩，标记重合的数字，重合数字累加，同时k+1计算重合并累加
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long rightEnd = k;
        long dupSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > rightEnd) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                rightEnd++;
                dupSum += nums[i];
            }
        }
        long total = rightEnd * (1 + rightEnd) / 2;
        return total - dupSum;
    }
}
