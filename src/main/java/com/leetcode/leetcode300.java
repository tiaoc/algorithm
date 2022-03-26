package com.leetcode;

public class leetcode300 {
    //nlogn解法，动规+二分
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int res=0;
        for(int num:nums) {
            int left = 0, right = res;
            while (left<=right){
                int m=(left+right)/2;
                if(dp[m]<=num){
                    left=m+1;
                }else {
                    right=m;
                }
            }
            dp[left]=num;
            if(res==right)res++;
        }
        return res;
    }
    //n方解法，动态规划
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length == 0) return 0;
//        int[]dp=new int[nums.length];
//        Arrays.fill(dp,1);
//        int res=1;
//        for(int i=0;i<nums.length;i++){
//            for(int j=0;j<i;j++){
//                if(nums[j]<nums[i]){
//                    dp[i]=Math.max(dp[i],dp[j]+1);
//                }
//            }
//            res=Math.max(res,dp[i]);
//        }
//        return res;
//    }
}
