package com.leetcode;

import java.util.Arrays;

public class leetcode5832 {
    /*每个元素都不等于其两侧相邻元素的平均值
    * 返回任一重排结果
    * 左+右！=中*2
    * 互不相同的 整数
    *
[1,5,2,6,3,7,4,8]
    * */
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[]res=new int[n];
        int i=0,j=(n+1)/2,idx=0;
        while(j<n){
            res[idx++]=nums[i++];
            res[idx++]=nums[j++];
        }
        if(idx!=n-1){
            res[idx]=nums[i];
        }
        return res;
    }
}
