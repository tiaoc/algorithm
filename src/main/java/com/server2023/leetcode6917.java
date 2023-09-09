package com.server2023;

public class leetcode6917 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int h : hours) {
            if (h >= target) {
                res++;
            }
        }
        return res;
    }
}
