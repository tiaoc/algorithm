package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode6255 {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] cities = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            cities[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            cities[r[0]].add(new int[]{r[1], r[2]});
            cities[r[1]].add(new int[]{r[0], r[2]});
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int min = Integer.MAX_VALUE;
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int[] dest : cities[cur]) {
                if (!visited[dest[0]]) {
                    queue.add(dest[0]);
                }
                min = Math.min(min, dest[1]);
            }
        }
        return min;
    }
}
