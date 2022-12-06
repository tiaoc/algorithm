package com.lcp;

import java.util.Arrays;

public class S01 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int x = op[0], y = op[1];
            int give = gem[x] / 2;
            int resume = (gem[x] + 1) / 2;
            gem[x] = resume;
            gem[y] += give;
        }
        int min = Arrays.stream(gem).min().getAsInt();
        int max = Arrays.stream(gem).max().getAsInt();
        return max - min;
    }
}
