package com.server2022;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.StringJoiner;

public class Leetcode5253 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(new int[]{9}, 5)));
    }

    //笛卡尔积
    public static long[] kthPalindrome(int[] queries, int intLength) {
        int dup = intLength / 2;
        int mod = intLength % 2;
        int inners = mod == 1 ? dup : dup - 1;
        long sum = 9 * (long) Math.pow(10, inners);
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            if (cur > sum) {
                res[i] = -1;
            } else if (cur == sum) {
                long num = 0, c = 0;
                while (c < intLength) {
                    num += 9 * (long) Math.pow(10, c);
                    c++;
                }
                res[i] = num;
            } else {
                long partSize = sum / 9;
                long curValue = cur / partSize;
                long resume = cur % partSize;
                long num = 0;
                if (resume == 0) {
                    curValue--;
                }
                num += (curValue + 1) * (long) Math.pow(10, intLength - 1);
                if (inners != 0 || mod == 0) {
                    num += curValue + 1;
                }
                int layer = 0;
                while (layer++ < inners) {
                    partSize /= 10;
                    curValue = resume / partSize;
                    resume %= partSize;
                    if (resume == 0) {
                        curValue = (curValue + 9) % 10;
                    }
                    num += curValue * (long) Math.pow(10, layer);
                    if (layer != inners || mod == 0) {
                        num += curValue * (long) Math.pow(10, intLength - 1 - layer);
                    }
                }
                res[i] = num;
            }
        }
        return res;
    }
}
