package com.leetcode;

import java.util.Arrays;

public class leetcode6134 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,0,0};
        System.out.println(closestMeetingNode(arr, 2, 0));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] pass1 = new int[n];
        int[] pass2 = new int[n];
        Arrays.fill(pass1, -1);
        Arrays.fill(pass2, -1);
        pass1[node1] = 0;
        pass2[node2] = 0;
        int cur = node1;
        int dis = 0;
        while (true) {
            int next = edges[cur];
            dis++;
            if (next != -1 && pass1[next] == -1) {
                pass1[next] = dis;
            } else {
                break;
            }
            cur = next;
        }
        cur = node2;
        dis = 0;
        while (true) {
            int next = edges[cur];
            dis++;
            if (next != -1 && pass2[next] == -1) {
                pass2[next] = dis;
            } else {
                break;
            }
            cur = next;
        }
        int gap = Integer.MAX_VALUE;
        int min = -1;
        for (int i = 0; i < n; i++) {
            if (pass1[i] != -1 && pass2[i] != -1) {
                int t = Math.max(pass1[i], pass2[i]);
                if (t < gap) {
                    gap = t;
                    min = i;
                }
            }
        }
        return min;
    }
}
