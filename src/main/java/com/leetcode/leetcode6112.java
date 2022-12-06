package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode6112 {
    // 尽可能装不同类型的水-
    //
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : amount) {
            queue.add(num);
        }
        int count = 0;
        while (!queue.isEmpty() && queue.peek() > 0) {
            int a = queue.poll(), b = 0;
            if (!queue.isEmpty()) {
                b = queue.poll();
            }
            --a;
            --b;
            if (a > 0) {
                queue.add(a);
            }
            if (b > 0) {
                queue.add(b);
            }
            ++count;
        }
        return count;
    }
}
