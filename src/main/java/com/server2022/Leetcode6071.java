package com.server2022;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6071 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : tasks) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return -1;
            }
            int count = e.getValue() / 3;
            int mod = e.getValue() % 3;
            count += mod > 0 ? 1 : 0;
            res += count;
        }
        return res;
    }
}
