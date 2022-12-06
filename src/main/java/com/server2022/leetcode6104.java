package com.server2022;

public class leetcode6104 {
    public int countAsterisks(String s) {
        char[] arr = s.toCharArray();
        boolean f = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '|') {
                f = !f;
            }
            if (!f && arr[i] == '*') {
                count++;
            }
        }
        return count;
    }
}
