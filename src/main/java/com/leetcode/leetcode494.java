package com.leetcode;

import javax.print.DocFlavor;
import java.util.Arrays;

public class leetcode494 {
    public static void main(String[] args) {
        int []nums= {1, 1, 1, 1, 1};
        int S= 3;
        System.out.println(findTargetSumWays(nums,S));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        if(S>1000) return 0;
        int[][] dp=new int[nums.length][2001];
        dp[0][nums[0]+1000]=1;
        dp[0][-nums[0]+1000]+=1;
        for(int i=1;i<nums.length;i++) {
            for(int j=-1000;j<=1000;j++){
                if(dp[i-1][j+1000]>0) {//在之前的情况中肯定不存在j已经接近-1000
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        return dp[nums.length-1][S+1000];
    }
}
