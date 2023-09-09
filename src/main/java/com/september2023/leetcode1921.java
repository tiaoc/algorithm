package com.september2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] % speed[i] == 0) {
                list.add(dist[i] / speed[i] - 1);
            } else {
                list.add(dist[i] / speed[i]);
            }
        }
        list.sort(Comparator.comparingInt(a -> a));
        int i = 0;
        // 判断怪物会在几回合后挨到城市，根据这个消灭
        while (i < list.size()) {
            if (list.get(i) < i) {
                return i;
            }
            i++;
        }
        return i;
    }
}
