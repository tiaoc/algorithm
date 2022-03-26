package com.leetcode;

public class leetcode6004 {
    public int countOperations(int num1, int num2) {
        int c = 0;
        while (num1 != 0 && num2 != 0) {
            int b = Math.abs(num1 - num2);
            num1 = Math.min(num1, num2);
            num2 = b;
            ++c;
        }
        return c;
    }
}
