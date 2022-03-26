package com.leetcode;

import java.util.Arrays;

public class leetcode123 {
//    来看一下两者有什么不同
//1>买入就算一次交易：
//    i天t次交易现在手上不持有 = max(i-1天t次交易手上不持有，i-1天t次交易手上持有 + i天卖出价格prices)
//    dp[t][i][0] = max(dp[t][i - 1][0], dp[t][i - 1] + prices[i]);
//
//    i天t次交易现在手上持有 = max(i-1天t次交易手上持有，i-1天t-1次交易手上不持有 - i天买入价格)
//    dp[t][i][1] = max(dp[t][i - 1][1], dp[t - 1][i - 1][0] - prices[i])
//
//2>买入后卖出才算一次交易
//    i天t次交易现在手上不持有 = max(i天t次交易手上不持有，i - 1天t - 1次交易 + i天卖出)
//    dp[t][i][0] = max(dp[t][i][0], dp[t - 1][i - 1][1] + prices[i])
//
//    i天t次交易现在手上持有 = max(i天t次交易现在手上持有，i - 1天t次交易 + i天买入)
//    dp[t][i][1] = max(dp[t][i][1], dp[t][i - 1][0] - prices[i])

    public static void main(String[] args) {
        int[] price={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(price));
    }
    //最多交易两次
    public static int maxProfit(int[] prices) {
        int k=2;
        int[][] dp =new int[k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=k;j>=1;j--){
                if(i==0){
                    dp[j][0]=0;
                    dp[j][1]=-prices[i];
                    continue;
                }
                dp[j][0]=Math.max(dp[j][1]+prices[i],dp[j][0]);
                dp[j][1]=Math.max(dp[j-1][0]-prices[i],dp[j][1]);
                System.out.println(Arrays.toString(dp[j]));
            }
        }
        return dp[k][0];
    }
    //i-1 带k，三维版本
    public int maxProfit(int k, int[] prices) {
        if(k/2>prices.length) return 0;
        int[][][] dp =new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=k;j>=1;j--){
                if(i==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                    continue;
                }
                dp[i][j][0]=Math.max(dp[i-1][j-1][1]+prices[i],dp[i-1][j][0]);
                dp[i][j][1]=Math.max(dp[i-1][j][0]-prices[i],dp[i-1][j][1]);
            }
        }
        return dp[prices.length-1][k][0];
    }
    //带k二维版本
//    public int maxProfit(int k, int[] prices) {
//        if (k / 2 > prices.length) return 0;
//        int[][] dp = new int[k + 1][2];
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = k; j >= 1; j--) {
//                if (i == 0) {
//                    dp[j][0] = 0;
//                    dp[j][1] = -prices[i];
//                    continue;
//                }
//                dp[j][0] = Math.max(dp[j][1] + prices[i], dp[j][0]);
//                dp[j][1] = Math.max(dp[j - 1][0] - prices[i], dp[j][1]);
//            }
//        }
//        return dp[k][0];
//    }
}
