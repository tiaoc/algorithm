package com.leetcode;

public class leetcode6021 {
    public long maximumSubsequenceCount(String text, String pattern) {
        int front = 0, back = 0;
        long sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                front++;
            }
            if (text.charAt(i) == pattern.charAt(1)) {
                back++;
                if (pattern.charAt(0) == pattern.charAt(1)) {
                    sum += front - 1;
                } else {
                    sum += front;
                }
            }
        }
        if (front < back) {
            sum += back;
        } else if (front > back) {
            sum += front;
        } else if (front != 0) {
            sum += front;
        }
        return sum;
    }
}
