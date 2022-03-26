package com.leetcode;

import java.util.Arrays;

public class leetcode279 {
    public static void main(String[] args) {
        System.out.println(numSquares(188));
    }
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,20000);
        int val=1;
        for(int i=1;i<=n;i++){
            if(val*val==i){
                dp[i]=1;
                val++;
                continue;
            }
            for(int j=1;j<i;j++){
                dp[i]=Math.min(dp[i],dp[i-j]+dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
