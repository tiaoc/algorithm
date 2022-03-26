package com.leetcode;

import java.util.Arrays;

public class leetcode5854 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length==1){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i + k < nums.length; i++) {
            res=Math.min(res,nums[i+k]-nums[i]);
        }
        return res;
    }
}
