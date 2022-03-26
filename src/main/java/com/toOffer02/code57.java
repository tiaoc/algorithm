package com.toOffer02;

public class code57 {
    /*这么写时间复杂度太高，因为每次都是一个新数组中二分查找
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            int remain=target-nums[i];
            while (start<=end){
                int m=(start+end)>>1;
                if(nums[m]<remain){
                    start=m+1;
                }else if(nums[m]>remain){
                    end=m-1;
                }else {
                    return new int[]{nums[i], nums[m]};
                }
            }
        }
        return new int[]{};
    }
     */

//    public int[] twoSum(int[] nums, int target) {
//        int start=0,end=nums.length-1;
//        while(start<end){//start/end 一个在左一个在右，不能相交
//            if(nums[start]+nums[end]<target){
//                start++;//只在左找
//            }else if(nums[start]+nums[end]>target){
//                end--;//只在右找
//            }else{
//                return new int[]{nums[start],nums[end]};
//            }
//        }
//        return new int[]{};
//    }
    //二分是等于分出来的+1或-1，这个是平推
    public int[] twoSum(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<end){
            if(nums[start]+nums[end]<target){
                start++;
            }else if(nums[start]+nums[end]>target){
                end--;
            }else {
                return new int[]{nums[start],nums[end]};
            }
        }
        return new int[]{};
    }
}
