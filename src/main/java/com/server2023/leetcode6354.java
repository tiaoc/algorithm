package com.server2023;

public class leetcode6354 {
    public static void main(String[] args) {
        System.out.println(new leetcode6354().findTheArrayConcVal(new int[]{5,14,13,8,12}));
    }
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[nums.length - i - 1];
            int len = 0;
            while (temp > 0) {
                temp /= 10;
                len++;
            }
            res += (long) nums[i] * Math.pow(10, len) + nums[nums.length - i - 1];
        }
        if (nums.length % 2 != 0) {
            res += nums[nums.length / 2];
        }
        return res;
    }
}
