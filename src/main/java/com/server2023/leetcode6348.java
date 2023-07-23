package com.server2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode6348 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>((a,b)-> (int) (b - a));
        Arrays.stream(gifts).forEach(g -> queue.offer((long) g));
        for (int i = 0; i < k; i++) {
            long v = queue.poll();
            long next = (long) Math.sqrt(v);
            queue.offer(next);
        }
        long res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}
