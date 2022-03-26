package com.leetcode;

import java.util.Arrays;
public class leetcode6010 {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long sum = Arrays.stream(time).sum();
        long maxTime = Math.max(sum, (long) totalTrips * (long) time[time.length - 1] / time.length);
        long left = 0, right = maxTime;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tripCount = cost(time, mid);
            if (tripCount < totalTrips) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long cost(int[] time, long curTime) {
        long count = 0;
        for (int bus : time) {
            count += curTime / (long) bus;
        }
        return count;
    }
}
