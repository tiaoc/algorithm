package com.server2023;

import com.leetcode.leetcode554;

import java.util.Arrays;

public class leetcode6368 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new leetcode6368().divisibilityArray("1010", 10)));
    }

    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int t = m, count = 0;
        while (t > 0) {
            t /= 10;
            count++;
        }

        int[] res = new int[n];
        for (int i = 0; i < count && i < n; i++) {
            int s = word.charAt(i) - '0';
            if (s == 0) {
                res[i] = 1;
            } else {
                break;
            }
        }
        if (count > n) {
            return res;
        }
        long v = Long.parseLong(word.substring(0, count));
        long mod = v % m;
        if (mod == 0) {
            res[count - 1] = 1;
        }
        for (int i = count; i < n; i++) {
            mod = mod * 10 + word.charAt(i) - '0';
            mod %= m;
            if (mod == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}
