package com.leetcode;

public class leetcode5958 {
    public long getDescentPeriods(int[] prices) {
        long[] dp=new long[prices.length];
        int curDesLen=1;
        dp[0]=1;
        for (int i=1;i<prices.length;i++){
            if(prices[i]==prices[i-1]-1){
                dp[i]=dp[i-1]+1+curDesLen;
                curDesLen++;
            }else{
                dp[i]=dp[i-1]+1;
                curDesLen=1;
            }
        }
        return dp[prices.length-1];
    }
}
