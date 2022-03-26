package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode322coins {
    public static void main(String[] args) {
        int amount=11;
        int[] coins={1,2,5};
        System.out.println(coinChange(coins,amount));
    }
    //凑硬币最少数量（不是恰好等于，而是价值最小）-》取min
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;//只有恰好为0的时候，才满足条件，其他的初值设置为最大值，不可以作为初值
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        if(dp[amount]==amount+1){
            return -1;
        }
        return dp[amount];
    }
    //dfs+剪枝（备忘录）
//    public static int coinChange(int[] coins, int amount) {
//        if(map.get(amount)!=null){
//            return map.get(amount);
//        }
//        if(amount==0) return 0;
//        if(amount<0) return -1;
//        int result=Integer.MAX_VALUE;
//        for(int i=0;i<coins.length;i++){
//            int subMin=coinChange(coins,amount-coins[i])+1;
//            if(subMin==0) continue;
//            result=Math.min(result,subMin);
//        }
//        if(result== Integer.MAX_VALUE){
//            return -1;
//        }
//        map.put(amount,result);
//        return result;
//    }
}
