package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode5863 {
    //不同四元组，可以重复，计算个数
    public static void main(String[] args) {
        int[] nums={56,50,33,1,86,80,85,42,90};
        System.out.println(new leetcode5863().countQuadruplets(nums));
    }
    public int countQuadruplets(int[] nums) {
        HashMap<Integer,Integer>map;
        int n=nums.length;
        int res=0;
        for(int i=n-1;i>2;i--){
            int sum=nums[i];
            for(int j=i-1;j>1;j--) {
                for(int k=j-1;k>0;k--){
                    for(int x=k-1;x>=0;x--){
                        if(nums[k]+nums[j]+nums[x]==sum){
                            System.out.println(i+" "+nums[i]);
                            System.out.println(j+" "+nums[j]);
                            System.out.println(k+" "+nums[k]);
                            System.out.println(x+" "+nums[x]);
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
