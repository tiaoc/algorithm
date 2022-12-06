package com.server2022;

public class leetcode6090 {
    public int minMaxGame(int[] nums) {
        int[] temp = nums;
        while (temp.length > 1) {
            int len = temp.length / 2;
            int[] next = new int[len];
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    next[i] = Math.min(temp[2 * i], temp[2 * i + 1]);
                } else {
                    next[i] = Math.max(temp[2 * i], temp[2 * i + 1]);
                }
            }
            temp = next;
        }
        return temp[0];
    }
}
