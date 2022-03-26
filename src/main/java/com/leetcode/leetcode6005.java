package com.leetcode;

import java.util.HashMap;

public class leetcode6005 {
    public static void main(String[] args) {
        System.out.println(new leetcode6005().minimumOperations(new int[]{4, 4, 4, 4, 3, 4}));
    }

    // 奇数位和偶数位
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        int evenValue = -1, oddValue = -1, v2 = -1, v3 = -1;
        for (int i = 0; i < nums.length; i += 2) {
            even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            if (even.getOrDefault(evenValue, 0) <= even.get(nums[i])) {
                if(evenValue != nums[i]) {
                    v2 = evenValue;
                    evenValue = nums[i];
                }
            } else if (even.getOrDefault(v2, 0) <= even.get(nums[i])) {
                v2 = nums[i];
            }
        }
        for (int i = 1; i < nums.length; i += 2) {
            odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            if (odd.getOrDefault(oddValue, 0) <= odd.get(nums[i])) {
                if(oddValue != nums[i]) {
                    v3 = oddValue;
                    oddValue = nums[i];
                }
            } else if (odd.getOrDefault(v3, 0) <= odd.get(nums[i])) {
                v3 = nums[i];
            }
        }
        if (evenValue == oddValue) {
            int v = Math.max(even.getOrDefault(evenValue, 0) + odd.getOrDefault(v3, 0), odd.getOrDefault(oddValue, 0) + even.getOrDefault(v2, 0));
            return nums.length - v;
        }
        return nums.length - even.getOrDefault(evenValue, 0) - odd.getOrDefault(oddValue, 0);
    }
}
