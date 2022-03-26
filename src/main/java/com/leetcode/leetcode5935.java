package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//湍流数组？
public class leetcode5935 {
    //每个位置记录最长递增和最长递减，递增查现在，递减查后面（二分？不行）
    //递减和递增不同时存在
    //递减的结束是在当前天之后，当前天+个time，看这时的递减天是否》=time
    //增和减是一起的，增+1，减-1
    public static void main(String[] args) {
        System.out.println(goodDaysToRobBank(new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8}, 2));
    }

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            if (security[i - 1] < security[i]) {
                if (dp[i - 1][0] > 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = 1;
                }
                dp[i][1] = 0;
            } else if (security[i - 1] > security[i]) {
                if (dp[i - 1][1] > 0) {
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][1] = 1;
                }
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (dp[i][1] >= time && dp[i + time][0] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
