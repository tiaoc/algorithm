package com.server2022;

public class leetcode6078 {
    public int rearrangeCharacters(String s, String target) {
        int[] counts = new int[26];
        for (char c : target.toCharArray()) {
            counts[c - 'a']++;
        }
        int[] resource = new int[26];
        for (char c : s.toCharArray()) {
            resource[c - 'a']++;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                count = Math.min(count, resource[i] / counts[i]);
            }
        }
        return count;
    }
}
