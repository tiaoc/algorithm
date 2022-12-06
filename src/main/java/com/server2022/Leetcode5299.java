package com.server2022;

public class Leetcode5299 {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            if (i + k <= s.length()) {
                int v = Integer.parseInt(s.substring(i, i + k));
                if (v != 0 && num % v == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
