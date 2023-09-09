package com.server2023;

import java.util.*;

public class leetcode7022 {
    public static void main(String[] args) {
        System.out.println(new leetcode7022().minAbsoluteDifference(Arrays.asList(4, 3, 2, 4), 2));
    }

    // 窗口，左边窗口在增加，右边窗口在减少
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int res = Integer.MAX_VALUE;
        TreeSet<Integer> left = new TreeSet<>();
        for (int i = x; i < nums.size(); i++) {
            left.add(nums.get(i - x));
            int num = nums.get(i);
            Integer tL = left.ceiling(num);
            Integer tR = left.floor(num);
            res = Math.min(res, Math.min(tL == null ? Integer.MAX_VALUE : Math.abs(tL - num),
                    tR == null ? Integer.MAX_VALUE : Math.abs(tR - num)));
        }
        return res;
    }

}
