package com.leetcode;

import java.util.Arrays;

public class leetcode6009 {
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            res += Math.abs(counts[i]);
        }
        return res;
    }
}
