package com.server2022;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode6085 {
    // 计算和，各个城市的加权累加和，权是计算个数，值依次赋值。
    // 确定每个城市加的次数，排序，赋权，n到1即可
    // 确定加的次数
    public long maximumImportance(int n, int[][] roads) {
        int[] city = new int[n];
        for (int[] r : roads) {
            city[r[0]]++;
            city[r[1]]++;
        }
        Arrays.sort(city);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += (long) i * city[i-1];
        }
        return res;
    }
}
