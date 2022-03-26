package com.leetcode;

import java.util.*;

public class leetcode539 {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<>(timePoints.size() * 2);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            String[] time = timePoints.get(i).split(":");
            int cur = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            list.add(cur);
            list.add(24 * 60 + cur);
        }
        list.sort(Comparator.comparingInt(o -> o));
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(list.get(i) - list.get(i - 1), res);
        }
        return res;
    }
}
