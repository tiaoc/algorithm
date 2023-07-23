package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode207 {
    // 有向连接，无环。 bfs? 找节点的前置，再找其前置，一直找下去如果没找到此次查询访问过的节点，则正常。
    // 第一个节点会出现什么问题，它的后置节点
    // 直接建图呢？每个节点找父？经过的节点就标记visit。
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            list.get(pair[0]).add(pair[1]);
        }
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, list, flag)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, List<List<Integer>> list, int[] flag) {
        if (flag[cur] == -1) {
            return true;
        }
        if (flag[cur] == 1) {
            return false;
        }
        flag[cur] = 1;
        List<Integer> pre = list.get(cur);
        for (int v : pre) {
            if (!dfs(v, list, flag)) {
                return false;
            }
        }
        flag[cur] = -1;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            list.get(pair[1]).add(pair[0]);
            inDegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited++;
            for (int next : list.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return visited == numCourses;
    }
}
