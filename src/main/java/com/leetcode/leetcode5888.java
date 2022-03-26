package com.leetcode;

import java.util.*;

public class leetcode5888 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}};
        int[] patience = new int[]{0, 2, 1};
        System.out.println(new leetcode5888().networkBecomesIdle(edges, patience));
    }

    //最后一次的重发消息的返回，和 发消息的返回 的最小值。
    //记录每个点到服务器的距离
    //每个重发请求，都要得到回应,bfs
    //记忆化 bfs，太帅了,保证先遍历的边是靠近0的边
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int len = patience.length;
        int[] distance = new int[len];
        HashSet[] map = new HashSet[len];
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            map[i] = new HashSet<Integer>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            HashSet<Integer> next=map[cur];
            for (Integer idx : next) {
                if (!visited[idx]) {
                    distance[idx] = distance[cur] + 1;
                    visited[idx] = true;
                    queue.offer(idx);
                }
            }
        }
        int lastTime = 0;
        //自己会不会发也取决于其他点有没有结束吗？不是
        for (int i = 1; i < distance.length; i++) {
            lastTime = Math.max(lastTime, (distance[i] * 2 - 1) / patience[i] * patience[i] + distance[i] * 2);
        }
        return lastTime + 1;
    }
}

