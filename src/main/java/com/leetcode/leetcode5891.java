package com.leetcode;

import java.util.Arrays;

public class leetcode5891 {
    public static void main(String[] args) {
        System.out.println(13/3);
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int sum=mean*(m+n);
        for(int num:rolls){
            sum-=num;
        }
        if(n * 6<sum || n >sum){
            return new int[]{};
        }
        int[] res=new int[n];
        if( sum % n ==0){
            Arrays.fill(res,sum/n);
            return res;
        }
        int mMean=sum/n;
        for (int i=0;i<n-1;i++){
            res[i]=mMean+1;
            sum-=res[i];
            mMean=sum/(n-i-1);
        }
        res[n-1]=sum;
        return res;
    }
}

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int sum=mean*(m+n);
        for(int num:rolls){
            sum-=num;
        }
        if(n * 6<sum || n >sum){
            return new int[]{};
        }
        int[] res=new int[n];
        if( sum % n ==0){
            Arrays.fill(res,sum/n);
            return res;
        }
        int mMean=sum/n;
        for (int i=0;i<n-1;i++){
            res[i]=mMean+1;
            sum-=res[i];
            mMean=sum/(n-i-1);
            if( sum % (n-i-1) ==0){
                Arrays.fill(res, i+1,n,mMean);
                break;
            }
        }
        return res;
    }
}