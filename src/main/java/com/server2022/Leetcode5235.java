package com.server2022;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.putIfAbsent(match[1], 0);
            map.put(match[1], map.get(match[1]) + 1);
        }
        List<Integer> ans1 = map.entrySet().stream().filter(e -> e.getValue() == 0).map(Map.Entry::getKey).collect(Collectors.toList());
        ans1.sort(Comparator.comparingInt(o -> o));
        List<Integer> ans2 = map.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        ans2.sort(Comparator.comparingInt(o -> o));
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
