package com.leetcode;

import java.util.Arrays;

public class leetcode34 {
    public static void main(String[] args) {
        int[]nums=new int[]{2,2};
        int target=1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int[] res=new int[2];
        int left=0,right=nums.length-1;
        while(left<right){
            int mid =(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(right<0||right>=nums.length||nums[right]!=target){
            return new int[]{-1,-1};
        }
        res[0]=right;
        left=0;
        right=nums.length-1;
        while(left<right){
            float midd =(float)(left+right)/2;
            int mid=(int) Math.ceil(midd);
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                left=mid;
            }
        }
        res[1]=right;
        return res;
    }
}
