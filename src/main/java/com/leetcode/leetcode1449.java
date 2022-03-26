package com.leetcode;

import java.util.Arrays;

public class leetcode1449 {
    public static void main(String[] args) {
        int[] cost = {4,3,2,5,6,7,2,5,5};
        int target=9;
        System.out.println(largestNumber(cost,target));
    }
    public static String largestNumber(int[] cost, int target) {
        String[]dp=new String[target];
        Arrays.fill(dp,"");
        for(int i=0;i<target;i++){
            for(int j=0;j<cost.length;j++){
                if(i+cost[j]<target&&!compare(dp[i+cost[j]],dp[i]+(j+1))){
                    dp[i+cost[j]]=dp[i]+(j+1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target-1];
    }
    private static boolean compare (String a,String b){
        if(a.length()==b.length()){
            return a.compareTo(b)>0;
        }
        return a.length()>b.length();
    }
}
