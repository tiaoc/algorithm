package com.server2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode6065 {
    public static void main(String[] args) {
        int[] a = new int[]{16, 17, 71, 62, 12, 24, 14};
        System.out.println(largestCombination(a));
    }

    //二进制权重 是1. 有多个1添加到组合中
    public static int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int count = 0;
            for (int c : candidates) {
                if ((c & bit) != 0) {
                    ++count;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
