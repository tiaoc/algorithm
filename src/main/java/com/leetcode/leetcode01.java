package com.leetcode;

import java.util.Arrays;

public class leetcode01 {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start=0,end=nums.length-1;
        while(start<end){
            if(nums[start]+nums[end]>target){
                end--;
            }else if(nums[start]+nums[end]<target){
                start++;
            }else {
                return new int[]{start,end};
            }
        }
        return new int[]{};
    }
}
