package com.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class leetcode6006 {
    // 非空袋子相等，不能放入 于是是最小值,但可以拿空，于是最小值可以变
    // 拿出的豆子数目最少 不在乎次数
    // 一方面是拿空 另一方面是裁剪
    public static void main(String[] args) {
        System.out.println(new leetcode6006().minimumRemoval(new int[]{4,1,6,5}));
    }
    public long minimumRemoval(int[] beans) {
        long ret = Long.MAX_VALUE;
        Arrays.sort(beans);
        long front[] = new long[beans.length];
        long end[] = new long[beans.length];
        for (int i = 1; i < beans.length; i++) {
            front[i] = front[i - 1] + beans[i - 1];
        }
        for (int i = beans.length - 2; i >= 0; i--) {
            end[i] = end[i + 1] + beans[i + 1];
        }
        for (int i = 0; i < beans.length; i++) {
            long b =(long)(beans.length - i - 1) * (long)beans[i];
            long v = front[i] + end[i] - b;
            ret = Math.min(ret, v);
        }
        return ret;
    }
}
