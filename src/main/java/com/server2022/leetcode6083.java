package com.server2022;

import java.util.Arrays;

public class leetcode6083 {
    public boolean digitCount(String num) {
        int[] count = new int[11];
        boolean first = true;
        for (int i = 0; i < num.length(); i++) {
            if (first && num.charAt(i) == '0' && i < num.length() - 1) {
                continue;
            }
            first = false;
            count[num.charAt(i) - '0']++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != count[i]) {
                return false;
            }
        }
        return true;
    }
}
