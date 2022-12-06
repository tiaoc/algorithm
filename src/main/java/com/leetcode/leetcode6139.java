package com.leetcode;

import java.util.*;

public class leetcode6139 {
    public static void main(String[] args) {
        System.out.println(reachableNodes(7, new int[][]{{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}}, new int[]{2, 7}));
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int r : restricted) {
            set.add(r);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (set.contains(cur) || visited[cur]) {
                continue;
            }
            visited[cur] = true;
            count++;
            List<Integer> next = list.get(cur);
            queue.addAll(next);
        }
        return count;
    }
}
