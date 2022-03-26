package com.toOffer02;

public class code63 {
    public int maxProfit(int[] prices) {
        int diff=0,min=Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            if (price - min > diff) {
                diff = price - min;
            }
        }
        return diff;
    }
}
