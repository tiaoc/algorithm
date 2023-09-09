package com.september2023;

import java.util.List;

public class leetcode2511 {
    public int captureForts(int[] forts) {
        int idx = 0;
        int res = 0;
        while (idx < forts.length) {
            int cur = forts[idx];
            if (cur == 1 || cur == -1) {
                int count = 0;
                idx++;
                while (idx < forts.length && forts[idx] == 0) {
                    idx++;
                    count++;
                }
                if (idx < forts.length && forts[idx] == -cur) {
                    res = Math.max(res, count);
                }
            } else {
                idx++;
            }
        }
        return res;
    }

    // 升序在第一根柱子上
    // 1 2 3 4 5     3 4 5   2   1   3 4 5  1 2  _   4 5  1 2 3   1 5  2 3   4    1 5  3  24    5 3 124
    // 把比自己小一位的顺子挪到自己头上
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        int n = a.size();
        move(n, a, b, c);
    }

    // a经过b移到c
    void move(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            c.add(0, a.remove(0));
            return;
        }
        // 把n上面的放到c (原先的b)
        move(n - 1, a, c, b);
        // 把n放到c
        c.add(0, a.remove(0));
        // 把 b上的n-1放到c
        move(n - 1, b, a, c);
    }
}
