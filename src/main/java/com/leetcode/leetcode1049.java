package com.leetcode;

import java.util.Arrays;

public class leetcode1049 {
    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
    //转换成01背包问题，求两堆石头的最小差值。由于石头总和为sum.则问题转换成了
    //背包最多装sum / 2的石头,stones数组里有一大堆石头。求如何装能装下最多重量石头。
    public static int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return sum-2*dp[target];
    }
}
