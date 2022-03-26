package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode5815 {
    public static void main(String[] args) {

    }
    //每行选一个格子
    public long maxPoints(int[][] points) {
        int m=points.length,n=points[0].length;
        long [] dp=new long[n];
        for(int i=m-1;i>=0;i--){
            long lmax=0,rmax=0;
            long[] temp=new long[n];
            for(int j=0;j<n;j++){
                lmax=Math.max(lmax-1,dp[j]+points[i][j]);
                temp[j]=lmax;
            }
            for(int j=n-1;j>=0;j--){
                rmax=Math.max(rmax-1,dp[j]+points[i][j]);
                temp[j]=Math.max(rmax,temp[j]);
            }
            dp=temp;
        }
        long res=0;
        for(int j=0;j<n;j++){
            res=Math.max(dp[j],res);
        }
        return res;
    }
}
