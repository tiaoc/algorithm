package com.server2023;

import java.util.*;

public class leetcode6900 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> total = new HashSet<>();
        for (int n : nums) {
            total.add(n);
        }
        int totalSize = total.size();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> cur = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                cur.add(nums[j]);
                if (cur.size() == totalSize) {
                    res++;
                }
            }
        }
        return res;
    }
}
