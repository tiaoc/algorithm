package com.toOffer02;

public class code42 {
    public static void main(String[] args) {
        int[] num={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
    }
    public static int maxSubArray(int[] nums) {
        int res=nums[0];
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]+=Math.max(0,sum[i-1]);
            sum[i]+=nums[i];
            if (sum[i]>res) res=sum[i];
        }
        return res;
    }
}
