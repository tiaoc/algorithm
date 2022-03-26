package com.leetcode;

public class leetcode5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n=plants.length;
        int a=0,b=n-1,waterA=capacityA,waterB=capacityB;
        int res=0;
        while(a<b){
            if(waterA>=plants[a]){
                waterA-=plants[a++];
            }else {
                waterA=capacityA-plants[a++];
                res++;
            }
            if(waterB>=plants[b]){
                waterB-=plants[b--];
            }else {
                waterB=capacityB-plants[b--];
                res++;
            }
        }
        if(a==b){
            if(waterA>=waterB){
                if(waterA<plants[a]){
                    res++;
                }
            }else {
                if(waterB<plants[a]){
                    res++;
                }
            }
        }
        return res;
    }
}
