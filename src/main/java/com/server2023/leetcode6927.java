package com.server2023;

import java.util.*;

public class leetcode6927 {
    public static void main(String[] args) {
        System.out.println(new leetcode6927().minimumIndex(Arrays.asList(1, 2, 2, 2)));
        System.out.println(new leetcode6927().minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));
    }

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxV = 0;
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
            if (count > maxCount) {
                maxV = n;
                maxCount = count;
            }
        }
        int[] prefix = new int[nums.size() + 1];
        for (int i = 1; i <= nums.size(); i++) {
            prefix[i] = prefix[i - 1];
            if (nums.get(i - 1) == maxV) {
                prefix[i]++;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            int l = prefix[i + 1];
            int r = prefix[nums.size()] - prefix[i + 1];
            if (i + 1 - l < l && nums.size() - 1 - i - r < r) {
                return i;
            }
        }
        return -1;
    }
}
