package com.leetcode;

public class leetcode6157 {
    public int secondsToRemoveOccurrences(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        boolean flag;
        while (true) {
            flag = false;
            for (int i = 1; i < cs.length; i++) {
                if (cs[i - 1] == '0' && cs[i] == '1') {
                    cs[i - 1] = '1';
                    cs[i] = '0';
                    flag = true;
                    i++;
                }
            }
            if (!flag) {
                break;
            }
            cnt++;
        }
        return cnt;
    }

    public int secondsToRemoveOccurrences2(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        int idx = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '0') {
                idx++;
                cnt = Math.max(cnt, cs.length - idx - i);
            }
        }
        return cnt;
    }
}
