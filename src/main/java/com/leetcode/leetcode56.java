package com.leetcode;

import java.util.*;

public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> stack = new ArrayDeque<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            while (!stack.isEmpty() && (stack.peek()[1] >= interval[0] && stack.peek()[0] <= interval[0])) {
                int[] a = stack.pop();
                start = a[0];
                end = Math.max(a[1], end);
            }
            stack.push(new int[]{start, end});
        }
        return new ArrayList<>(stack).toArray(new int[0][]);
    }
}
