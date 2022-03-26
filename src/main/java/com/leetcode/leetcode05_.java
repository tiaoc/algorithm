package com.leetcode;

public class leetcode05_ {
    public static void main(String[] args) {
        String str = "abddba";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int m = 0, n = 0;
        //j在外面，i在里面，先判断回文长度小的，再逐次判断回文长度大的（以各个i为中心）
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length()-j; i++) {
                if (s.charAt(i) == s.charAt(i + j)) {
        //j<3隔离了s[i]=s[i+j],j=1的情况，否则dp[i][i+1]就等于dp[i+1][i],失去了向内层求值的意义
                    dp[i][i + j] = j < 3 || dp[i + 1][i + j - 1];
                    if (dp[i][i + j] && j > n) {
                        m = i;
                        n = j;
                    }
                } else {
                    dp[i][i + j] = false;
                }
            }
        }
        return s.substring(m, m + n + 1);
    }
}
