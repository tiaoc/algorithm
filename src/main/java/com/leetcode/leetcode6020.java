package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode6020 {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for (Map.Entry<Integer, Integer> v : map.entrySet()) {
            if (v.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
