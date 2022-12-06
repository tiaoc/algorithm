package com.server2022;

import com.base.ListNode;

public class leetcode6111 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int state = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        int x = 0, y = 0;
        while (count < m * n) {
            if (head == null) {
                res[x][y] = -1;
            } else {
                res[x][y] = head.val;
                head = head.next;
            }
            visited[x][y] = true;
            int nextX = x + dir[state][0], nextY = y + dir[state][1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                state = (state + 1) % 4;
            }
            x = x + dir[state][0];
            y = y + dir[state][1];
            count++;
        }
        return res;
    }
}
