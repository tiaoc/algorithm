package com.leetcode;

public class leetcode33 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,0,1,1,1};
        System.out.println(search2(nums,0));
    }
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int m=(left+right)/2;
            if(nums[m]==target) return m;
            if(nums[0]<=nums[m]) {//如果小于，则0到m有序，否则，m到nums[length-1]有序
                if (target <nums[m] && target >= nums[left]) {
                    //不能写两个等于（关于m的地方），会造成无限循环
                    //无限循环的原因，？
                    //而且在m的地方等于，造成下面只能写=m
                    right=m-1;
                }else {
                    left=m+1;
                }
            }else {
                if(target<=nums[right]&&target>nums[m]){
                    left=m+1;
                }else {
                    right=m-1;
                }
            }
        }
        return -1;
    }
    public static int search2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[0]<=nums[mid]){//mid在左有序数组
                if(nums[mid]>target&&nums[left]<=target){
                    right=mid-1;
                }else if(nums[mid]==target){
                    return mid;
                }else{
                    left=mid+1;
                }
            }else{////mid在右有序数组
                if(nums[mid]<target&&nums[right]>=target){
                    left=mid+1;
                }else if(nums[mid]==target){
                    return mid;
                }else {
                    right=mid-1;
                }
            }
            //System.out.println(left);
            //System.out.println(right);
        }
        return -1;
    }
}
