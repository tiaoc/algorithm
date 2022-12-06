package com.leetcode;

import java.util.Arrays;

public class leetcode6149 {
    public int edgeScore(int[] edges) {
        long[] nodes = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i]] += i;
        }
        long max = 0;
        int res = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] > max) {
                res = i;
                max = nodes[i];
            }
        }
        return res;
    }
}
