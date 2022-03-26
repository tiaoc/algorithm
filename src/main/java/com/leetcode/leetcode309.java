package com.leetcode;

public class leetcode309 {
    //    public static int maxProfit(int[] prices) {
//        int [][] dp=new int[prices.length][2];
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        for(int i=1;i<prices.length;i++){
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            //之前没有，现在也没有/之前有，现在卖了。
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
//            //之前没有，现在买了/之前有，现在不动。
//            //i-1[0]来自于i-2[0]和i-2[1],排除掉i-2[1]，只剩下i-2[0]
//        }
//        return dp[prices.length-1][0];
//    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        int dpi0 = 0, dpi1 = Integer.MIN_VALUE, prei0 = 0;//循环从0开始，直接判断0要不要买，
        // 相当于定义了i=-1的状态
        for (int i = 0; i < prices.length; i++) {
            int temp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            //之前没有，现在也没有/之前有，现在卖了。
            dpi1 = Math.max(dpi1, prei0 - prices[i]);
            //之前没有，现在买了/之前有，现在不动。
            //i-1[0]来自于i-2[0]和i-2[1],排除掉i-2[1]，只剩下i-2[0]
            prei0 = temp;
        }
        return dpi0;
    }
}
