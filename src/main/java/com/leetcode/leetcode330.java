package com.leetcode;

import java.util.Arrays;

public class leetcode330 {
    public static void main(String[] args) {
        int [] nums={};
        int n=8;
        System.out.println(minPatches(nums,n));
    }
    public static int minPatches(int[] nums, int n) {
        boolean[] interval=new boolean[n+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>n){
                break;
            }
            for(int j=n;j>=1;j--){
                if(nums[i]+j>n){
                    continue;
                }
                if(interval[j]){
                    interval[nums[i]+j]=true;
                }
            }
            interval[nums[i]]=true;
        }
        System.out.println(Arrays.toString(interval));
        boolean flag=false;
        int res=0;
        while(!flag){
            flag=true;
            int temp=0;
            for(int i=1;i<=n;i++){
                if(!interval[i]){
                    temp=i;
                    res++;
                    break;
                }
            }
            for(int i=n;i>=1;i--){
                if(temp+i>n){
                    continue;
                }
                if(interval[i]){
                    interval[temp+i]=true;
                }
            }
            interval[temp]=true;
            int[] t=new int[nums.length+1];
            System.arraycopy(nums, 0, t, 0, nums.length);
            t[nums.length]=temp;
            Arrays.sort(t);
            nums=t;
            for(int i=1;i<=n;i++){
                flag=flag&&interval[i];
            }
            System.out.println(Arrays.toString(interval));
        }
        return res;
    }
}
