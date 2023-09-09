package com.server2023;

import java.util.*;

public class leetcode6925 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 子数组，长度大于2，m需要小于m
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2) {
            return true;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode6925().maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 0, 1)
                , Arrays.asList(0, 0, 0, 0), Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 0, 0, 0))));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<int[]> disQueue = new LinkedList<>();
        int[][] coefficient = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(coefficient[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    disQueue.add(new int[]{i, j, 0});
                    coefficient[i][j] = 0;
                }
            }
        }
        while (!disQueue.isEmpty()) {
            int[] node = disQueue.poll();
            int x = node[0], y = node[1], z = coefficient[x][y];
            if (x + 1 < n && coefficient[x + 1][y] == Integer.MAX_VALUE) {
                disQueue.add(new int[]{x + 1, y, node[2] + 1});
                coefficient[x + 1][y] = z + 1;
            }
            if (y + 1 < n && coefficient[x][y + 1] == Integer.MAX_VALUE) {
                disQueue.add(new int[]{x, y + 1, node[2] + 1});
                coefficient[x][y + 1] = z + 1;
            }
            if (x - 1 >= 0 && coefficient[x - 1][y] == Integer.MAX_VALUE) {
                disQueue.add(new int[]{x - 1, y, node[2] + 1});
                coefficient[x - 1][y] = z + 1;
            }
            if (y - 1 >= 0 && coefficient[x][y - 1] == Integer.MAX_VALUE) {
                disQueue.add(new int[]{x, y - 1, node[2] + 1});
                coefficient[x][y - 1] = z + 1;
            }
        }
        int[][] maxSecurity = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, coefficient[0][0]});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            if (x + 1 < n && maxSecurity[x + 1][y] < Math.min(node[2], coefficient[x + 1][y])) {
                queue.add(new int[]{x + 1, y,Math.min(node[2], coefficient[x + 1][y])});
                maxSecurity[x + 1][y] =Math.min(node[2], coefficient[x + 1][y]);
            }
            if (y + 1 < n && maxSecurity[x][y + 1] < Math.min(node[2], coefficient[x][y + 1])) {
                queue.add(new int[]{x, y + 1, Math.min(node[2], coefficient[x][y + 1])});
                maxSecurity[x][y + 1] = Math.min(node[2], coefficient[x][y + 1]);
            }
            if (x - 1 >= 0 && maxSecurity[x - 1][y] < Math.min(node[2], coefficient[x - 1][y])) {
                queue.add(new int[]{x - 1, y, Math.min(node[2], coefficient[x - 1][y])});
                maxSecurity[x - 1][y] = Math.min(node[2], coefficient[x - 1][y]);
            }
            if (y - 1 >= 0 && maxSecurity[x][y - 1] < Math.min(node[2], coefficient[x][y - 1])) {
                queue.add(new int[]{x, y - 1, Math.min(node[2], coefficient[x][y - 1])});
                maxSecurity[x][y - 1] = Math.min(node[2], coefficient[x][y - 1]);
            }
        }
        return maxSecurity[n - 1][n - 1];
    }

}
