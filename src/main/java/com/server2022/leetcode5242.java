package com.server2022;

public class leetcode5242 {
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }
        for (int i = lower.length - 1; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                return String.valueOf((char) (i + 'A'));
            }
        }
        return "";
    }
}
