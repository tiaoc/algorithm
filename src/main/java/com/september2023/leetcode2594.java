package com.september2023;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode2594 {
    // r * n方修n个车
    // cars 分给多个（不一定是全部）机械工，其中的最长时间。领到固定份额的任务。
    // 能力强的人多修
    // 不能每次找出最合理的步骤去转移。
    public static void main(String[] args) {
        System.out.println(new leetcode2594().repairCars(new int[]{4, 3, 2, 1}, 10));
    }

    public long repairCars(int[] ranks, int cars) {
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> (int) (a[2] - b[2]));
        for (int rank : ranks) {
            queue.offer(new long[]{rank, 0, rank});
        }
        int i = 0;
        while (i < cars) {
            long[] r = queue.poll();
            queue.offer(new long[]{r[0], r[1] + 1, r[0] * (long) Math.pow(r[1] + 2, 2)});
            i++;
        }
        long res = 0;
        while (!queue.isEmpty()) {
            long[] r = queue.poll();
            res = Math.max(res, r[0] * r[1] * r[1]);
        }
        return res;
    }
}
