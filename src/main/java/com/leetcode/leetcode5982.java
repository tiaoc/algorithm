package com.leetcode;

import java.util.Arrays;

public class leetcode5982 {
    public static void main(String[] args) {
        int[][] q = new int[][]{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
        System.out.println(mostPoints(q));
    }
    public static long mostPoints(int[][] questions) {
        long[] dp =new long[questions.length];
        long curMax=0;
        for(int i=0;i<questions.length;i++){
            curMax = Math.max(dp[i],curMax);
            dp[i] = questions[i][0] + curMax;
            if(i+questions[i][1] +1 < questions.length){
                dp[i+questions[i][1]+1] = Math.max(dp[i],dp[i+questions[i][1]+1]);
            }
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}
