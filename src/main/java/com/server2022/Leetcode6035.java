package com.server2022;

public class Leetcode6035 {

    // 长度为3的波动子序列的个数
    // 记录1的个数 记录0的个数，记录上一个1到这一个1出现之间的0的个数，记为gapZero，
    // 当前1产生的次数就等于上一个1的次数(curOne) 加上 上一个1到这一个1本身所产生的次数(gapZero)。
    public long numberOfWays(String s) {
        int zero = 0, gapOne = 0, gapZero = 0;
        long curZero = 0, curOne = 0, count =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (gapOne > 0) {
                    curZero += (long) gapOne * zero;
                    gapOne = 0;
                }
                ++gapZero;
                count += curZero;
                zero++;
            } else {
                if (gapZero > 0) {
                    curOne += (long) gapZero * (i - zero);
                    gapZero = 0;
                }
                ++gapOne;
                count += curOne;
            }
        }
        return count;
    }

}
