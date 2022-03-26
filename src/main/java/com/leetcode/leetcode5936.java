package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode5936 {
    // (x1-x0)2 + (y1-y0)2 <= r2
    //单向传递 r是两个圆心之间的大值（或两个r都可以满足）
    //圆心list，dfs每个节点能爆的数量？数量不行，得精确，否则不能继承关系，每个bomb记一个se
    boolean[] visited;
    int max = 0;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        visited = new boolean[n];
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, dfs(i, bombs));
            Arrays.fill(visited, false);
        }
        return max;
    }

    private int dfs(int cur, int[][] bombs) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        int val = 1;
        for (int i = 0; i < bombs.length; i++) {
            if(Math.pow(bombs[i][1]-bombs[cur][1],2)+Math.pow(bombs[i][0]-bombs[cur][0],2)<=Math.pow(bombs[cur][2],2)) {
                val += dfs(i, bombs);
            }
        }
        return val;
    }
}
