package com.lcp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SG02 {
    public static void main(String[] args) {
        String[] matrix = new String[]{">^^>","<^v>","^v^<"};
        int[] st = new int[]{0, 0};
        int[] ed = new int[]{1, 3};
        System.out.println(new SG02().conveyorBelt(matrix, st, ed));
    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int m = matrix.length, n = matrix[0].length();
        int[][] cache = new int[m][n];
        for (int[] c : cache) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{end[0], end[1], 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[2]>=cache[cur[0]][cur[1]]){
                continue;
            }
            cache[cur[0]][cur[1]]=cur[2];
            if (cur[0] > 0 && cache[cur[0] - 1][cur[1]] > cur[2]) {
                int t = 1;
                if (matrix[cur[0] - 1].charAt(cur[1]) == 'v') {
                    t = 0;
                }
                if (cur[2] + t < cache[cur[0] - 1][cur[1]]) {
                    queue.add(new int[]{cur[0] - 1, cur[1], cur[2] + t});
                }
            }
            if (cur[0] < m - 1 && cache[cur[0] + 1][cur[1]] > cur[2]) {
                int t = 1;
                if (matrix[cur[0] + 1].charAt(cur[1]) == '^') {
                    t = 0;
                }
                if (cur[2] + t < cache[cur[0] + 1][cur[1]]) {
                    queue.add(new int[]{cur[0] + 1, cur[1], cur[2] + t});
                }
            }
            if (cur[1] > 0 && cache[cur[0]][cur[1] - 1] > cur[2]) {
                int t = 1;
                if (matrix[cur[0]].charAt(cur[1] - 1) == '>') {
                    t = 0;
                }
                if (cur[2] + t < cache[cur[0]][cur[1] - 1]) {
                    queue.add(new int[]{cur[0], cur[1] - 1, cur[2] + t});
                }
            }
            if (cur[1] < n - 1 && cache[cur[0]][cur[1] + 1] > cur[2]) {
                int t = 1;
                if (matrix[cur[0]].charAt(cur[1] + 1) == '<') {
                    t = 0;
                }
                if (cur[2] + t < cache[cur[0]][cur[1] + 1]) {
                    queue.add(new int[]{cur[0], cur[1] + 1, cur[2] + t});
                }
            }
        }
        return cache[start[0]][start[1]];
    }
}
