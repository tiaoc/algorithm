package com.toOffer02;

public class code53_2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = (end + start) / 2;
            if (nums[middle] <= middle) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }
}
