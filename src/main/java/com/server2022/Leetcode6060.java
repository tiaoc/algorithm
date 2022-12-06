package com.server2022;

public class Leetcode6060 {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(res) || Math.abs(num) == Math.abs(res) && num > 0) {
                res = num;
            }
        }
        return res;
    }
}
