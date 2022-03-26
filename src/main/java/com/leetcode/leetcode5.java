package com.leetcode;

import java.util.Arrays;

public class leetcode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
    public static String longestPalindrome(String s) {
        int n=s.length();
        boolean [][] dp=new boolean[n][n];
        //dp[i][j]表示以ij为两端的子字符串的回文情况
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],true);
        }
        int dif=0;
        String str="";
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if(dp[i][j]&&j-i+1>dif){
                    dif=j-i+1;
                    str=s.substring(i,j+1);
                }
            }
        }
        return str;
    }
}
