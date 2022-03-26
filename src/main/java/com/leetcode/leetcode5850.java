package com.leetcode;

import java.util.Arrays;

public class leetcode5850 {
    public int findGCD(int[] nums) {
        int min= Arrays.stream(nums).min().getAsInt();
        int max= Arrays.stream(nums).max().getAsInt();
        int res=min;
        while(max%res!=0){
            int temp=(max+res)%res;
            max=res;
            res=temp;
        }
        return res;
    }
}
