package com.leetcode;

import java.util.Arrays;

public class leetcode188 {
    public static void main(String[] args) {
        int k=2;
        int[] prices={3,2,6,5,0,3};
        System.out.println(maxProfit(k,prices));
    }
    public static int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][] dp=new int[k+1][2];
        //在初始化过程中，不能想当然地只将第1次交易的持有状态写为-price[0]。
        //将每个j都初始化为-price[0]，防止带入0，影响后面的计算（比如成本本来是负的多少，带入0，则改变了成本）
        //每个j都初始化为-price[0]，相当于进行第j次交易的的成本是-price[0]，这个状态会被后面的迭代所修改状态，被过滤掉，是重复计算，但不必担心。
        for(int i=0;i<=k;i++){
            dp[i][1]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=k;j>=0;j--){
                //卖出计算交易次数，买入不计算
                if(j==0){
                    dp[j][1]=Math.max(dp[j][1],-prices[i]);
                    continue;
                }
                dp[j][0]=Math.max(dp[j][0],dp[j-1][1]+prices[i]);
                dp[j][1]=Math.max(dp[j][1],dp[j][0]-prices[i]);
            }
        }
        return dp[k][0];
    }
}
