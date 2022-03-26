package com.leetcode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class leetcode6024 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> arr = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        return arr.get(0).getKey();
    }
}
