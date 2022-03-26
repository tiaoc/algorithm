package com.leetcode;

public class leetcode5972 {
    // 考虑越界
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = lower, max = upper;
        int change = 0;
        for (int i = 0; i < differences.length; i++) {
            change += differences[i];
            if (min + change < lower) {
                min = lower - change;
            }
            if (max + change > upper) {
                max = upper - change;
            }
        }
        if (max >= min) {
            return max - min + 1;
        }
        return 0;
    }
}
