package com.server2022;

import java.util.Arrays;

public class leetcode6064 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int i = 0;
        while (i < special.length && special[i] < bottom) {
            i++;
        }
        int j = i, res = 0;
        if (i != special.length) {
            res = special[i] - bottom;
        }
        while (j < special.length && j < top) {
            res = Math.max(special[j] - special[i] - 1, res);
            i = j;
            j++;
        }
        res = Math.max(top - special[i], res);
        return res;
    }
}
