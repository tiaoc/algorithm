package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode2813 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        Set<Integer> win = new HashSet<>();
        long winValue = 0L, res = 0L;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < items.length; i++) {
            if (i < k) {
                if (win.contains(items[i][1])) {
                    stack.push(items[i][0]);
                }
                win.add(items[i][1]);
                winValue += items[i][0];
            } else {
                if (!win.contains(items[i][1]) && win.size() < k) {
                    //删除重复类中中值较小的
                    int remove = stack.poll();
                    winValue -= remove;
                    winValue += items[i][0];
                    win.add(items[i][1]);
                }
            }
            long temp = winValue + (long) win.size() * win.size();
            res = Math.max(res, temp);
        }
        return res;
    }
}
