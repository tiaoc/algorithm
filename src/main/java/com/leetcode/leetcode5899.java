package com.leetcode;

import java.util.Arrays;

public class leetcode5899 {
    public static void main(String[] args) {
        int[][] e=new int[][]{ {1,3,2},{4,5,2},{2,4,3}};
        System.out.println(new leetcode5899().maxTwoEvents(e));
    }
    //dp，如果按照活动的结束时间对活动排序，开始时间不能等于上一活动的结束时间
    //start end value
    //按照事件的结束点排
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] == b[1]) {
                return 0;
            }
            return -1;
        });
        int eventLength = events.length;
        int maxTime = events[eventLength - 1][1] + 2;
        int[] dp = new int[maxTime];
        for (int i = 0; i < maxTime; i++) {
            for (int j = 0; j < eventLength; j++) {
                if (events[j][1] >= i) {
                    break;
                }
                dp[events[j][1]] = Math.max(dp[events[j][1]], dp[events[j][0]]+events[j][2]);
            }
            for (int j=0;j <i;j++){
                dp[i]=Math.max(dp[i], dp[j]);
            }
        }
        int res=0;
        for(int i=0 ; i<maxTime;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
