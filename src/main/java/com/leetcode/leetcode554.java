package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int edge = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int num = list.get(i);
                edge += num;
                map.put(edge, map.getOrDefault(edge, 0) + 1);
            }
        }
        int v = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            v = Math.max(entry.getValue(), v);
        }
        return wall.size() - v;
    }

}
