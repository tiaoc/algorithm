package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode6173 {
    // 每行1的位置不同，写出来？，一个set list
    int res = 0;

    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length;
        List<Set<Integer>> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    s.add(j);
                }
            }
            l.add(s);
        }
        boolean[] visited = new boolean[n];
        dfs(0, l, visited, cols, 0);
        return res;
    }

    private void dfs(int cur, List<Set<Integer>> l, boolean[] visited, int cols, int count) {
        if (count == cols) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    s.add(j);
                }
            }
            int r = 0;
            for (int i = 0; i < l.size(); i++) {
                boolean f = false;
                for (int v : l.get(i)) {
                    if (!s.contains(v)) {
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    r++;
                }
                res = Math.max(r, res);
            }
            return;
        }else if (cur == visited.length){
            return;
        }
        for (int i = cur; i < visited.length; i++) {
            visited[i] = true;
            dfs(i + 1, l, visited, cols, count + 1);
            visited[i] = false;
        }
    }
}
