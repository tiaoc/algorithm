package com.leetcode;

public class leetcode6124 {
    public char repeatedCharacter(String s) {
        char[] arr = s.toCharArray();
        boolean[] map = new boolean[26];
        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i] - 'a']) {
                return arr[i];
            } else {
                map[arr[i] - 'a'] = true;
            }
        }
        return 'a';
    }
}
