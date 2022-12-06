package com.server2022;

import java.util.Arrays;

public class leetcode6075 {
    //返回装满的
    //填满最好填满的
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(arr);
        int i = 0;
        while (i < n && additionalRocks >= arr[i]) {
            additionalRocks -= arr[i++];
        }
        return i;
    }
}
