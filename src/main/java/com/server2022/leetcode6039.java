package com.server2022;

import java.util.PriorityQueue;

//贪心加最小的
public class leetcode6039 {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int a = queue.poll() + 1;
            queue.offer(a);
        }
        long v = queue.poll();
        while (!queue.isEmpty()) {
            v = (v * (long) queue.poll()) % mod;
        }
        return (int)v;
    }
}
