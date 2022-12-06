package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode2477 {
    // 底部到0，深度，每个节点到0的路径，按个数算
    // 恰好n-1条路
    // 深度，合并下属节点
    long res = 0;
    boolean[] visited;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> cities = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            cities.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            cities.get(road[0]).add(road[1]);
            cities.get(road[1]).add(road[0]);
        }
        visited[0] = true;
        for (int next : cities.get(0)) {
            dfs(cities, seats, next);
        }
        return res;
    }

    public long dfs(List<List<Integer>> cities, int seats, int cur) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        long sum = 1;
        for (int next : cities.get(cur)) {
            long v = dfs(cities, seats, next);
            sum += v;
        }
        res += Math.ceil(sum / (double) seats);
        return sum;
    }
}
                                                