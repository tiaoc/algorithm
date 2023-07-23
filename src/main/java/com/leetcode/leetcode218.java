package com.leetcode;

import java.util.*;

public class leetcode218 {
    public static void main(String[] args) {
        int[][] p = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        //  System.out.println(new leetcode218().getSkyline(p));
        //  System.out.println(new leetcode218().getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
        // System.out.println(new leetcode218().getSkyline(new int[][]{{2,9,10},{9,12,15}}));
        //System.out.println(new leetcode218().getSkyline(new int[][]{{0, 2, 3}, {2, 4, 3}, {4, 6, 3}}));
        //  System.out.println(new leetcode218().getSkyline(new int[][]{{4,9,10},{4,9,15},{4,9,12},{10,12,10},{10,12,8}}));
        System.out.println(new leetcode218().getSkyline(new int[][]{{1, 38, 219}, {2, 19, 228},
                {2, 64, 106}, {45, 89, 229}, {61, 95, 190}, {40, 95, 4}, {68, 97, 175}}));

    }

    // 按左端点排序，逐个进入判断，进入判断前先判断有无出队列
    // 队列的出，如何出
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        Arrays.sort(buildings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> rs = new ArrayList<>();
        int lastOut = 0;
        boolean start = true;
        for (int i = 0; i < buildings.length; i++) {
            int[] cur = buildings[i];
            if (i < buildings.length - 1 && cur[0] == buildings[i + 1][0]) {
                queue.add(cur);
                continue;
            }
            int bound = cur[0];
            while (!queue.isEmpty() && queue.peek()[1] < bound) {
                int[] pre = queue.poll();
                if (lastOut >= pre[1] || !queue.isEmpty() && pre[1] == queue.peek()[0]) {
                    continue;
                }
                if (!queue.isEmpty() && queue.peek()[1] > pre[1] && queue.peek()[2] != pre[2]) {
                    rs.add(Arrays.asList(pre[1], queue.peek()[2]));
                } else {
                    rs.add(Arrays.asList(pre[1], 0));
                    start = true;
                }
                lastOut = pre[1];
            }
            int[] peek = queue.peek();
            start |= queue.isEmpty();
            queue.add(cur);
            if (start) {
                rs.add(Arrays.asList(queue.peek()[0], queue.peek()[2]));
                start = false;
                continue;
            }
            if (cur[2] < peek[2] && cur[0] == peek[0]) {
                rs.add(Arrays.asList(cur[0], peek[2]));
            } else if (cur[2] > peek[2]) {
                rs.add(Arrays.asList(cur[0], cur[2]));
            }
        }
        out(queue, lastOut, rs);
        return rs;
    }

    private void out(PriorityQueue<int[]> queue, int lastOut, List<List<Integer>> rs) {
        while (!queue.isEmpty()) {
            int[] pre = queue.poll();
            if (lastOut >= pre[1] || !queue.isEmpty() && pre[1] == queue.peek()[0]) {
                continue;
            }
            if (!queue.isEmpty() && queue.peek()[2] != pre[2] && queue.peek()[1] > pre[1]) {
                rs.add(Arrays.asList(pre[1], queue.peek()[2]));
            } else {
                rs.add(Arrays.asList(pre[1], 0));
            }
            lastOut = pre[1];
        }
    }

    //建筑的左边缘小于等于该坐标，右边缘大于该坐标
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        boundaries.sort(Comparator.comparingInt(a -> a));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<List<Integer>> rs = new ArrayList<>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            // 添加新的building，<=
            while (idx < n && buildings[idx][0] <= boundary) {
                queue.add(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            // 不考虑右边界<=
            while (!queue.isEmpty() && queue.peek()[0] <= boundary) {
                queue.poll();
            }
            int height = queue.isEmpty() ? 0 : queue.peek()[1];
            if (rs.isEmpty() || rs.get(rs.size() - 1).get(1) != height) {
                rs.add(Arrays.asList(boundary, height));
            }
        }
        return rs;
    }


}
