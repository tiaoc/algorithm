package com.leetcode;

public class leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length==0) return 0;
        int dpi0=0,dpi1=-prices[0];//循环从0开始，直接判断0要不要买，
        // 相当于定义了i=-1的状态
        for(int i=1;i<prices.length;i++){
            int temp=dpi0;
            dpi0=Math.max(dpi0,dpi1+prices[i]-fee);
            dpi1=Math.max(temp-prices[i],dpi1);
        }
        return dpi0;
    }
}
