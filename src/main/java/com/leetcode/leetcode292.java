package com.leetcode;

public class leetcode292 {
    // 8 7 6 5 4 3 2 1 0
    // 8- 765, 4 -321,
    public boolean canWinNim(int n) {
        if (n >= 100000) {
            return n % 4 != 0;
        }
        boolean[] arr = new boolean[n + 1];
        for (int i = n; i > 0; i--) {
            if (!arr[i]) {
                for (int j = 1; j < 4 && i - j >= 0; j++) {
                    arr[i - j] = true;
                }
            }
        }
        return arr[0];
    }
}
