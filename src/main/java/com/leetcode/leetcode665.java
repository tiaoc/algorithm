package com.leetcode;

public class leetcode665 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(checkPossibility(nums));
    }
    public static boolean checkPossibility(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int left=0,right=nums.length-1;
        while(left<nums.length-1&&nums[left]<=nums[++left]);
        while(0<right&&nums[right]>=nums[--right]);

        if(left==right+1){
            if(right==0||nums[right-1]<=nums[left]){
                return true;
            }
        }
        if(nums[right]<=nums[left]){
            return true;
        }
        return false;
    }
 }
