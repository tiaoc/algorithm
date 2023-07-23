package com.server2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode6347 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length + 1];
        int match = 0;
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < words.length; i++) {
            if (vowel.contains(words[i].charAt(0)) && vowel.contains(words[i].charAt(words[i].length() - 1))) {
                match++;
            }
            prefix[i + 1] = match;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = prefix[end + 1] - prefix[start];
        }
        return res;
    }
}
