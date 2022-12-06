package com.leetcode;

public class leetcode5259 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int last = 0;
        for (int i = 0; i < brackets.length; i++) {
            int hit = income - last;
            if (income > brackets[i][0]) {
                hit = brackets[i][0] - last;
            }
            res += (double) hit * brackets[i][1] / 100;
            if (income < brackets[i][0]) {
                break;
            }
            last = brackets[i][0];
        }
        return res;
    }
}
