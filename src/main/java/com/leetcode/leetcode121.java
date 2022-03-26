package com.leetcode;

import java.util.Arrays;

public class leetcode121 {
    public static void main(String[] args) {
        int[] price={7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }
    //    public int maxProfit(int[] prices) {
//        int minprice= Integer.MAX_VALUE,maxdif=0;
//        for(int i=0;i<prices.length;i++){
//            if(minprice>prices[i]){
//                minprice=prices[i];
//            }
//            if(prices[i]-minprice>maxdif){
//                maxdif=prices[i]-minprice;
//            }
//        }
//        return maxdif;
//    }
    //121
    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int [][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];//初值是-prices[0]
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //之前没有，现在也没有/之前有，现在卖了。
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            //之前没有，现在买了/之前有，现在不动。
            //只能买，卖一次，因此买之前是0，0-prices[i]
            //买之后的状态只能是-prices[i]
        }
        return dp[prices.length-1][0];
    }
    //122
//    public static int maxProfit(int[] prices) {
//        int [][] dp=new int[prices.length][2];
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        for(int i=1;i<prices.length;i++){
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            //之前没有，现在也没有/之前有，现在卖了。
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//            //之前没有，现在买了/之前有，现在不动。
//        }
//        return dp[prices.length-1][0];
//    }
}
