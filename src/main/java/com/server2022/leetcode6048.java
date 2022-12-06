package com.server2022;

import java.util.HashMap;
import java.util.Map;

public class leetcode6048 {
    //滑窗
    public int minimumCardPickup(int[] cards) {
        int gap = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                gap = Math.min(gap, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return gap == Integer.MAX_VALUE ? -1 : gap;
    }
}
