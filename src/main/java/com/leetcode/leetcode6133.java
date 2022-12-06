package com.leetcode;

import java.util.Arrays;

public class leetcode6133 {
    //间隔最小 递增  3 5 6 7 10 12
    // 1 1 1 1 12
    public int maximumGroups(int[] grades) {
        int max = 1;
        int count = 0, n = grades.length;
        int i = 0;
        while (i < n) {
            if (i + max > n) {
                break;
            }
            i += max;
            count++;
            max++;
        }
        return count;
    }
}
