package com.server2022;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class leetcode6076 {
    //斜率和上一个相同
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 5}, {5, 7}, {6, 6}, {7, 5}, {8, 4}, {9, 4}, {10, 4}};
        System.out.println(minimumLines(arr));
    }

    public static int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int n = stockPrices.length, count = 1;
        if (n <= 1) {
            return 0;
        }
        BigDecimal x = new BigDecimal(stockPrices[0][0]);
        BigDecimal y = new BigDecimal(stockPrices[0][1]);
        BigDecimal k = new BigDecimal(stockPrices[1][1]).subtract(y).divide(new BigDecimal(stockPrices[1][0]).subtract(x), 1000, RoundingMode.HALF_UP);
        y = new BigDecimal(stockPrices[1][1]);
        x = new BigDecimal(stockPrices[1][0]);
        for (int i = 2; i < n; i++) {
            int[] pair = stockPrices[i];
            BigDecimal temp = new BigDecimal(pair[1]).subtract(y).divide(new BigDecimal(pair[0]).subtract(x), 1000, RoundingMode.HALF_UP);
            if (!temp.equals(k)) {
                k = temp;
                count++;
            }
            y = new BigDecimal(pair[1]);
            x = new BigDecimal(pair[0]);
        }
        return count;
    }
}
