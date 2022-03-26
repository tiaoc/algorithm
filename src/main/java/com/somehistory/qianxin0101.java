package com.somehistory;

import java.util.Arrays;
import java.util.Scanner;

public class qianxin0101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(func(n));
    }
    public static int func(int n){
        int[] coins={2,3,1,5,4,3};
        int[] prices={2,2,3,1,5,2};
        int[][] dp=new int[n+1][n+1];
        dp[0][0]=0;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<6;k++) {
                    if(j>=prices[k]) {
                        dp[i][j] = Math.max(dp[i - 1][j-prices[k]] + coins[k], dp[i - 1][j]);
                    }
                }
            }
        }
        for(int i=0;i<n+1;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][n];
    }
}
