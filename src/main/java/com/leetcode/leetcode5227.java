package com.leetcode;

import java.util.Arrays;

public class leetcode5227 {
    // 出栈 出栈后的最大值和当前栈的值，和栈下一个顶的值
    // 入栈肯定是入最大值
    // 出栈入栈 两次操作
    // k过大，应该是没关系的
    public int maximumTop(int[] nums, int k) {
        if (k == 0) {
            return nums[k];
        }
        int end = k - 1;
        if (k - 1 >= nums.length) {
            end = nums.length;
        }
        int[] forward = Arrays.copyOfRange(nums, 0, end);
        Arrays.sort(forward);
        if (k > nums.length) {
            if (nums.length == 1 && k % 2 == 1) {
                return -1;
            }
            return forward[forward.length - 1];
        }
        if (k == nums.length) {
            if (nums.length == 1) {
                return -1;
            }
            return forward[forward.length - 1];
        }
        if(k == 1){
            return nums[k];
        }
        return Math.max(forward[forward.length - 1], nums[k]);
    }
}
