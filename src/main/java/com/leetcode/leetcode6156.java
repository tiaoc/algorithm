package com.leetcode;

public class leetcode6156 {
    public int minimumRecolors(String blocks, int k) {
        char[] cs = blocks.toCharArray();
        int res = k;
        for (int i = 0; i < cs.length; i++) {
            int cnt = 0;
            if (i + k > cs.length) {
                continue;
            }
            for (int j = i; j < i + k; j++) {
                if (cs[j] == 'W') {
                    cnt++;
                }
            }
            res = Math.min(res, cnt);
        }
        return res;
    }
}
