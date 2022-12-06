package com.server2022;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode6081 {
    // 洪泛法+历史移除的，bfs，不用考虑移除的顺序？、
    public static void main(String[] args) {
        int[][] g = new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(minimumObstacles(g));
    }

    // visited，优先级队列，一直消费优先级高的。
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>
                (Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return cur[2];
            }
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                queue.add(new int[]{x - 1, y, cur[2] + grid[x - 1][y]});
            }
            if (x + 1 < m && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                queue.add(new int[]{x + 1, y, cur[2] + grid[x + 1][y]});
            }
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                queue.add(new int[]{x, y - 1, cur[2] + grid[x][y - 1]});
            }
            if (y + 1 < n && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                queue.add(new int[]{x, y + 1, cur[2] + grid[x][y + 1]});
            }
        }
        return 0;
    }
}
