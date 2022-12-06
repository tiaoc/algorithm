package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetcode6171 {

    public static void main(String[] args) {
        System.out.println(new leetcode6171().findSubarrays(new int[]{1, 2, 3, 4, 5}));
    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (set.contains(nums[i] + nums[i + 1])) {
                return true;
            }
            set.add(nums[i] + nums[i + 1]);
        }
        return false;
    }
}
