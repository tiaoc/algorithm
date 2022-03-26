package com.leetcode;

public class leetcode6014 {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 25; i >= 0; i--) {
            while (counts[i] > 0) {
                int c = 0;
                while (counts[i] > 0 && c < repeatLimit) {
                    ++c;
                    --counts[i];
                    sb.append((char)(i + 'a'));
                }
                if (counts[i] > 0) {
                    boolean valFlag = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if (counts[j] > 0) {
                            --counts[j];
                            sb.append((char)(j + 'a'));
                            valFlag = true;
                            break;
                        }
                    }
                    if (!valFlag) {
                        return sb.toString();
                    }
                }
            }
        }
        return sb.toString();
    }
}
