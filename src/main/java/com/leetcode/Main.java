package com.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] price={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(price));
    }
    //最多交易两次
    public static int maxProfit(int[] prices) {
        int k=2;
        if(k/2>prices.length) return 0;
        int[][][] dp =new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=k;j>=1;j--){
                if(i==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                    continue;
                }
                dp[i][j][0]=Math.max(dp[i-1][j-1][1]+prices[i],dp[i][j][0]);
                dp[i][j][1]=Math.max(dp[i-1][j][0]-prices[i],dp[i][j][1]);
            }
            System.out.println(Arrays.deepToString(dp[i]));
        }
        return dp[prices.length-1][k][0];
    }
}
