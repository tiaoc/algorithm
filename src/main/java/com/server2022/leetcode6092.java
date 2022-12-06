package com.server2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode6092 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], (a) -> new LinkedList<>());
            map.get(nums[i]).add(i);
        }
        for (int[] opt : operations) {
            map.put(opt[1], map.get(opt[0]));
            map.remove(opt[0]);
        }
        int[] res = new int[nums.length];
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for (int idx : e.getValue()) {
                res[idx] = e.getKey();
            }
        }
        return res;
    }
}
