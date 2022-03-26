package com.leetcode;

import java.util.Scanner;

public class changes {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(func(n));
    }
    private static int func(int n){
        int[] coins={1,4,16,64};
        int num=1024-n;
        int[] dp=new int[num+1];
        dp[0]=0;
        for(int i=1;i<=num;i++){
            dp[i]=num+1;
        }
        for(int i=1;i<=num;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]]+1, dp[i]);
                }
            }
        }
        return dp[num];
    }
}
