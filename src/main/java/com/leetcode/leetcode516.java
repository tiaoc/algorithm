package com.leetcode;

import java.util.Arrays;

public class leetcode516 {
    //回文 怎么寻找
    //左右同时寻找
    //左边 右边所有
    //计算一个点 要保证他们中间的点被计算过，如何保证？
    //从中间开始计算，从一个点开始扩散。

    //考虑i，j的情况
    //0-i的情况没有被计算完全，但i+1到n-1的情况被计算完全了
    //j是0-i
    //原因在于 0-i依赖于完全正确的1-i-1，但实际上1-i-1是不正确的，那么对于状态转移来说，前序就不是一个无后效的重复计算结构
    //即不能用它表示状态的转移
    //0-i依赖于1-i-1

    //如何保证无后效？
    //i，j来说 如果 i+1-n-1被计算出来，i+1-n-1依赖于i+2-n-2

    //根本原因是这种dp不是按层来的，一次计算两次计算
    //如果是根据字符的位置来，一定要从右下角开始算。
    //ij依赖于i+1，j-1
    //对于先遍历的i，只计算了0-i-1,i，j都受限于0-i-1，对于后遍历的i，i，j都受限于i+1，n-1
    //但是对于ij所需要的i+1，j-1，i+1满足，j由于受限于i的大小（j>i,即j-1>=i)，当j-1>=i，对应情况的[i][j-1]也被计算过了
    //当j-1==i,此时左索引为i， i，j-1在i，j之前被计算。那么这个状态转移也是完备的
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public static int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            char cur=s.charAt(i);
            dp[i][i]=1;
            for(int j=0;j<i;j++){
                if(s.charAt(j)==cur){
                    if(j==0||i==n-1){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                }else{
                    if(j==0){
                        dp[i][j]=dp[i+1][j];
                    }else if(i==n-1){
                        dp[i][j]=dp[i][j+1];
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][0];
    }
}
