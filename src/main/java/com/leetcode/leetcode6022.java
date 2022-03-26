package com.leetcode;

import java.util.PriorityQueue;

public class leetcode6022 {
    public int halveArray(int[] nums) {
        double[] arr = new double[nums.length];
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> {
            if (b > a) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int num : nums) {
            queue.offer((double) num);
            sum += num;
        }
        int count = 0;
        double del = 0;
        while (del < sum / 2) {
            double v = queue.poll() / 2;
            del += v;
            queue.offer(v);
            count++;
        }
        return count;
    }
}
