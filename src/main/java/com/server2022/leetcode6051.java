package com.server2022;

public class leetcode6051 {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String w : words) {
            if (s.startsWith(w)) {
                count++;
            }
        }
        return count;
    }
}
