package com.server2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode6063 {
    // 1 8 3
    // 3 1 8
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<Integer>[] nodeRef = new List[n];
        for (int i = 0; i < n; i++) {
            nodeRef[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            nodeRef[edge[0]].add(edge[1]);
            nodeRef[edge[1]].add(edge[0]);
        }
        int res = -1;
        int [][] nodeTail = new int[n][];
        for (int i = 0; i < n; i++) {
            int temp = dfs(i, 0, nodeRef, scores, new HashSet<>(), i);
            res = Math.max(temp, res);
        }
        return res;
    }

    private int dfs(int cur, int depth, List<Integer>[] nodeRef, int[] scores, Set<Integer> nodes, int firstLayer) {
        if (depth == 3) {
            return scores[cur];
        }
        int res = 0;
        nodes.add(cur);
        for (int node : nodeRef[cur]) {
            if (nodes.contains(node) || depth == 0 && node <= firstLayer) {
                continue;
            }
            int temp = dfs(node, depth + 1, nodeRef, scores, nodes, firstLayer);
            if (temp > res) {
                res = temp;
            }
        }
        nodes.remove(cur);
        if (res == 0) {
            return -1;
        }
        return res + scores[cur];
    }
}
