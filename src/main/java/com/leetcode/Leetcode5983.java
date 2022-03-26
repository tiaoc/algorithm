package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode5983 {
    //电池个数对并发显示的限制，电量的限制
    //尽可能保证平整
    //全部电脑都有不重合的组合达到的小于等于平均值的时间
    //最大组合数
    // 3 4 5  5 3 (4)-2- 4 3 (1)
    // 3 4 5 = 3 +(0 1 2)
    // 9999 1  1   9999 1  1 9998
    // 电池及其容量 一次性
    //最大的+最小的
    //在每一时刻，都把电量大的电池扔进去
    public static void main(String[] args) {
        System.out.println(maxRunTime(2, new int[]{3, 3, 3}));
    }

    public static long maxRunTime(int n, int[] batteries) {
        long sum = Arrays.stream(batteries).asLongStream().sum();
        long left = 0, right = sum / n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long curSum = 0L;
            for (int b : batteries) {
                curSum += Math.min(b,mid);
            }
            if (n * mid <= curSum) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}
