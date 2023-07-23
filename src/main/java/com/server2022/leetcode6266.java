package com.server2022;

public class leetcode6266 {
    public static void main(String[] args) {
        System.out.println(smallestValue(30));//11
    }

    public static int smallestValue(int n) {
        int value = n;
        int j = 2;
        int add = 0;
        while (value != 1 && j < n / 2) {
            if (value % j != 0) {
                j++;
                continue;
            }
            while (value % j == 0) {
                add += j;
                value /= j;
            }
            j++;
        }
        if (add == 0) {
            return n;
        } else if (value == 1) {
            return smallestValue(add);
        } else {
            return smallestValue(add + value);
        }
    }
}
