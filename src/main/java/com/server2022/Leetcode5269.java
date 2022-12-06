package com.server2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode5269 {
    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(Arrays.asList(37, 88));
        piles.add(Arrays.asList(51, 64, 65, 20, 95, 30, 26));
        piles.add(Arrays.asList(9, 62, 20));
        piles.add(Arrays.asList(44));
        System.out.println(maxValueOfCoins(piles, 9));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][k + 1];
        int res = 0;
        for (int j = 1; j <= piles.get(0).size() && j <= k; j++) {
            dp[0][j] = dp[0][j - 1] + piles.get(0).get(j - 1);
        }
        for (int i = 1; i < piles.size(); i++) {
            List<Integer> pile = piles.get(i);
            int sum = 0;
            for (int j = 1; j <= pile.size() && j <= k; j++) {
                sum += pile.get(j - 1);
                for (int m = 0; m <= k; m++) {
                    if (m + j > k) {
                        break;
                    }
                    dp[i][m + j] = Math.max(dp[i - 1][m + j], Math.max(dp[i][m + j], dp[i - 1][m] + sum));
                }
            }
        }
        return dp[piles.size() - 1][k];
    }
}
