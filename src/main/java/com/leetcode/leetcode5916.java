package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode5916 {
    public static void main(String[] args) {
        int[] nums = {-21, 36, -12, 43, -4, -52, -93, 5, 12, 81, -90, 7, -31, -97, -49, 93, -65, 82, -37, 29, 87, -36, 70, 51, 60, -19, -73, -32, -13, -51, -23, 50};
        int start = 4, goal = 789;
        System.out.println(minimumOperations(nums, start, goal));
    }

    //保存到某个数的最小操作次数。如何剪枝
    //x在之前的操作中只能在0-1000。
    //0-1000中可到达的数，和目标数的操作数的最小值。
    //每次做一次操作，如果到达目标数已经是最小值
    // 分层bfs，queue，参见按行打印二叉树，这里用的是size--的方式，之前那道题用的是新建queue的方式
    public static int minimumOperations(int[] nums, int start, int goal) {
        boolean[] arr = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int count = 1;
        while (!queue.isEmpty()) {
            int size=queue.size();
            while(size-->0) {
                int cur = queue.poll();
                for (int num : nums) {
                    if (cur + num == goal || cur - num == goal || (cur ^ num) == goal) {
                        return count;
                    }
                    if (cur + num >= 0 && cur + num <= 1000 && !arr[cur + num]) {
                        arr[cur + num] = true;
                        queue.offer(cur + num);
                    }
                    if (cur - num >= 0 && cur - num <= 1000 && !arr[cur - num]) {
                        arr[cur - num] = true;
                        queue.offer(cur - num);
                    }
                    if ((cur ^ num) >= 0 && (cur ^ num) <= 1000 && !arr[cur ^ num]) {
                        arr[cur ^ num] = true;
                        queue.offer(cur ^ num);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
