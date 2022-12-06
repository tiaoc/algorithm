package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode6135 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,4,2,3};
        System.out.println(longestCycle(arr));
    }

    public static int longestCycle(int[] edges) {
        int n = edges.length;
        int res = -1;
        int[][] pass = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pass[i], -1);
        }
        for (int i = 0; i < n; i++) {
            if (pass[i][1] >= 0) {
                continue;
            }
            pass[i][0] = 0;
            pass[i][1] = i;
            int dis = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int next = edges[cur];
                dis++;
                if (next == -1) {
                    continue;
                }
                if (pass[next][1] == i) {
                    res = Math.max(res, dis - pass[next][0]);
                    break;
                } else if (pass[next][0] >= 0) {
                    break;
                }
                pass[next][0] = dis;
                pass[next][1] = i;
                queue.add(next);
            }
        }
        return res;
    }
}
