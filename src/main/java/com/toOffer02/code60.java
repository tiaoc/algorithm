package com.toOffer02;

import java.util.Arrays;

public class code60 {
//    public double[] twoSum(int n) {
//        int[][] nums = new int[n+1][6*n+1];//0+0=0,0+1=1,不适合用0到5表示1到6，因此要让n+1，6*n也要加1，去掉0.
//        double[] res=new double[6*n+1];
//        for (int i = 1; i <= 6; i ++) {//初始化n=1
//            nums[1][i] = 1;
//        }
//        for (int i = 2; i <= n; i++) {//从n=2开始，计算nums第二行的6n个值。
//            for (int j = i; j <= 6 * i; j++) {//轮流计算6n个值
//                for(int k=1;k<=6;k++){//当前值由前一个n的k-j个值决定如，如j=16，那么自己这次可以掷出1-6，前一个n的j=10到15，都能使得j=16
//                    if(j<=k){//当j=5时，只有前一个n的1-4课满足，5，6不行，因此当k>j时，要退出，不能继续计算
//                        break;
//                    }
//                    nums[i][j]+=nums[i-1][j-k];//直接加起来，计算频数。
//                }
//            }
//        }
//        for(int i=n;i<=6*n;i++){
//            res[i]=nums[n][i]/Math.pow(6,n);
//        }
//        return Arrays.copyOfRange(res,n,res.length);
//    }
    public double[] twoSum(int n) {
        int[] dp=new int[6*n+1];
        double[] res=new double[6*n+1];
        for(int i=1;i<7;i++){
            dp[i]=1;
        }
        for(int i=2;i<n+1;i++){
            for(int j=6*i;j>=i;j--){
                for(int k=1;k<7;k++){
                    if(j-k<n-1){
                        break;
                    }
                    dp[i]+=dp[j-k];
                }
            }
        }
        for(int i=n;i<6*n+1;i++){
            res[i]=dp[i]/Math.pow(6,n);
        }
        return Arrays.copyOfRange(res,n,6*n+1);
    }
}
