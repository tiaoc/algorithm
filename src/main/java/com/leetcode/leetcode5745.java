package com.leetcode;

import java.util.Arrays;

public class leetcode5745 {
    public static void main(String[] args) {
        int[] nums = {2,5,9};
        System.out.println(sumOfFlooredPairs(nums));
    }
    //floor
    //n*n次
    //自己和自己也要相除
    //一个图
    //二分搜索
    public static int sumOfFlooredPairs(int[] nums) {
        int mod=1000000007;
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[j]>nums[i]){
                    break;
                }
                res+=nums[i]/nums[j];
                res%=mod;
            }
        }
        return res;
    }
}
