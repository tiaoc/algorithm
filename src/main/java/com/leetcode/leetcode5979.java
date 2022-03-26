package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode5979 {
    //播种和另一个植物生长重合
    //可以让生长和播种重合的时间最大是多少
    //贪心 每次种播种短的，如果某个种生长时间过长呢？
    //0 1 1
    //  0 0 1
    //0 0 1
    //    0 1 1
    //优先种生长长的
    public static void main(String[] args) {
        int[] p = new int[]{1, 4, 3};
        int[] g = new int[]{2, 3, 1};
        System.out.println(earliestFullBloom(p, g));
    }

    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < plantTime.length; i++) {
            int[] cur = new int[]{plantTime[i], growTime[i]};
            queue.offer(cur);
        }
        int day = 0, store = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (store >= cur[0] + cur[1]) {
                store -= cur[0];
            } else if (store != 0) {
                day += cur[0] + cur[1] - store;
                store = cur[1];
            } else {
                day += cur[0] + cur[1];
                store = cur[1];
            }
        }
        return day;
    }
}
