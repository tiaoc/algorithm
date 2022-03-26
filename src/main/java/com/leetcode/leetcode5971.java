package com.leetcode;

import java.util.Arrays;

public class leetcode5971 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int mod = 1, value=0;
        for (int i=cost.length-1;i>=0;i--) {
            if (mod % 3 !=0) {
                value += cost[i];
            }
            mod++;
        }
        return value;
    }
}
