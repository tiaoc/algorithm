package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode5973 {
//    public  void main(String[] args) {
//        int[][] grid = {{1, 2, 0, 1}, {1, 3, 3, 1}, {0, 2, 5, 1}};
//        int[] pricing = {2, 3};
//        int[] start = {2, 3};
//        int k = 2;
//        System.out.println(highestRankedKItems(grid, pricing, start, k));
//    }

     boolean visited[][];
     List<List<Integer>> res;
     Queue<int[]> queue = new LinkedList<>();

    public  List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        res = new ArrayList<>();
        bfs(grid, pricing, start, k);
        return res;
    }

    private  void bfs(int[][] grid, int[] pricing, int[] start, int k) {
        visited[start[0]][start[1]] = true;
        queue.add(start);
        if (grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1]) {
            res.add(Arrays.stream(start).boxed().collect(Collectors.toList()));
            if (res.size() == k) {
                return;
            }
        }
        while (!queue.isEmpty()) {
            PriorityQueue<int[]> queue2 = new PriorityQueue<>((a, b) -> {
                if (grid[a[0]][a[1]] < grid[b[0]][b[1]]) {
                    return -1;
                } else if (grid[a[0]][a[1]] > grid[b[0]][b[1]]) {
                    return 1;
                } else if (a[0] < b[0] || a[0] == b[0] && a[1] < b[1]) {
                    return -1;
                }
                return 1;
            });
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int[] up = new int[]{cur[0] - 1, cur[1]};
                if (up[0] >= 0 && !visited[up[0]][up[1]] && grid[up[0]][up[1]] != 0) {
                    visited[up[0]][up[1]] = true;
                    queue2.offer(up);
                }
                int[] down = new int[]{cur[0] + 1, cur[1]};
                if (down[0] < grid.length && !visited[down[0]][down[1]] && grid[down[0]][down[1]] != 0) {
                    visited[down[0]][down[1]] = true;
                    queue2.offer(down);
                }
                int[] left = new int[]{cur[0], cur[1] - 1};
                if (left[1] >= 0 && !visited[left[0]][left[1]] && grid[left[0]][left[1]] != 0) {
                    visited[left[0]][left[1]] = true;
                    queue2.offer(left);
                }
                int[] right = new int[]{cur[0], cur[1] + 1};
                if (right[1] < grid[0].length && !visited[right[0]][right[1]] && grid[right[0]][right[1]] != 0) {
                    visited[right[0]][right[1]] = true;
                    queue2.offer(right);
                }
            }
            while (!queue2.isEmpty()) {
                int[] t = queue2.poll();
                queue.add(t);
                if (grid[t[0]][t[1]] >= pricing[0] && grid[t[0]][t[1]] <= pricing[1]) {
                    res.add(Arrays.stream(t).boxed().collect(Collectors.toList()));
                    if (res.size() == k) {
                        return;
                    }
                }
            }
        }
    }
}
