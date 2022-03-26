package com.leetcode;

public class leetcode06 {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int count = 0, nextGap;
            for (int j = i; j < s.length(); j += nextGap) {
                sb.append(s.charAt(j));
                if (numRows == 1) {
                    nextGap = 1;
                } else if ((count++ % 2 == 0 || i == 0) && i != numRows - 1) {
                    nextGap = 2 * (numRows - 1 - i);
                } else {
                    nextGap = 2 * i;
                }
            }
        }
        return sb.toString();
    }
}
