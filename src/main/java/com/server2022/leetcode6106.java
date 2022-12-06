package com.server2022;

import java.util.*;

public class leetcode6106 {
    public static void main(String[] args) {
        System.out.println(countPairs(5, new int[][]{{1, 0}, {3, 1}, {0, 4}, {2, 1}}));
    }

    // 到达，一个组，两个组，组内可互相到达。
    public static long countPairs(int n, int[][] edges) {
        List<Integer>[] arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] pair : edges) {
            arr[pair[0]].add(pair[1]);
            arr[pair[1]].add(pair[0]);
        }
        boolean[] visited = new boolean[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            int connect = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int idx : arr[cur]) {
                    if (!visited[idx]) {
                        visited[idx] = true;
                        connect++;
                        queue.add(idx);
                    }
                }
            }
            res += (long) connect * (n - connect);
        }
        return res / 2;
    }
}
