package com.leetcode;

import java.util.*;

public class leetcode5300 {
    // dfs
    // 一直添加
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> router = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            router.add(new HashSet<>());
        }
        for (int[] e : edges) {
            router.get(e[1]).add(e[0]);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ret.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (!ret.get(i).isEmpty()) {
                continue;
            }
            dfs2(router, i, ret);
        }
        return ret;
    }

    private Set<Integer> dfs2(List<Set<Integer>> router, int cur, List<List<Integer>> ret) {
        Set<Integer> set = new HashSet<>(router.get(cur));
        for (int j : router.get(cur)) {
            if (!ret.get(j).isEmpty()) {
                set.addAll(ret.get(j));
            } else {
                set.addAll(dfs2(router, j, ret));
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(a -> a));
        ret.set(cur, list);
        return set;
    }
}
