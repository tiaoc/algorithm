package com.leetcode;

import java.util.*;

public class leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int cur = i + map.get(list2[i]);
                if (cur < minSum) {
                    minSum = cur;
                    res = new ArrayList<>();
                    res.add(list2[i]);
                } else if (cur == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(String[]::new);
    }
}
