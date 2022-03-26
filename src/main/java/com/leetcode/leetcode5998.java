package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode5998 {
    // 余数 多少个2 减去后剩下多少个4
    public static void main(String[] args) {
        System.out.println(new leetcode5998().maximumEvenSplit(28));
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        long t = finalSum;
        for (long i = 2; i <= finalSum; i += 2) {
            if (t - i <= i && t!=i) {
                continue;
            }
            res.add(i);
            t -= i;
            if (t == 0) {
                break;
            }
        }
        return res;
    }
}
