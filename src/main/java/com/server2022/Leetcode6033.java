package com.server2022;

public class Leetcode6033 {
    public static void main(String[] args) {
        System.out.println(minBitFlips(3, 4));
    }

    public static int minBitFlips(int start, int goal) {
        int pow = 1, count = 0;
        while (start >= pow || goal >= pow) {
            if (start == 0) {
                int bit = goal & pow;
                if (bit == pow) {
                    ++count;
                }
            } else if (goal == 0) {
                int bit = start & pow;
                if (bit == pow) {
                    ++count;
                }
            } else {
                int bit = start & pow;
                int bit2 = goal & pow;
                if (bit != bit2) {
                    ++count;
                }
            }
            if (pow == 1) {
                pow++;
            } else {
                pow *= 2;
            }
        }
        return count;
    }
}
