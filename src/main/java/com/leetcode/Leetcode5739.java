package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode5739 {
    public static void main(String[] args) {
        int[] arr=new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        System.out.println(maxFrequency(arr,3056));
    }
    public static int maxFrequency2(int[] nums, int k) {
        Arrays.sort(nums);
        int pool_size=1;
        for(int i=0;i<nums.length;i++){
            int tk=k;
            int cur=nums[i];
            int temp_size=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==cur){
                    temp_size++;
                    continue;
                }
                if(tk<(nums[j]-cur)*temp_size){
                    break;
                }else{
                    tk-=(nums[j]-cur)*temp_size;
                    temp_size++;
                    cur=nums[j];
                }
                if(nums.length-j+temp_size<=pool_size){
                    break;
                }
            }
            System.out.println(temp_size);
            pool_size=Math.max(temp_size,pool_size);
        }
        return pool_size;
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] dif=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            dif[i]=nums[i]-nums[i-1];
        }
        //遍历起点
        int res=1;
        for(int i=0;i<nums.length;i++){
            int len=1;
            int cost=0;
            if(res>=nums.length-i){
                break;
            }
            for(int j=i+1;j<nums.length;j++){
                cost+=len*dif[j];
                if(cost>k){
                    break;
                }
                len++;
            }
            res=Math.max(len,res);
        }
        return res;
    }
}
