package com.leetcode;

import java.util.Arrays;

public class leetcode115 {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s,t));
    }
    public static  int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        int[][] dp=new int[m+1][n+1];
        // dp[i][j] s前i个，t前j个中匹配的个数
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=0;i<=m;i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }
}
