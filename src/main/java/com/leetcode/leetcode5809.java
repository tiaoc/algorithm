package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode5809 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; ++i) nums[i] = citations[i];
        Arrays.sort(nums, (o1, o2) -> o2 - o1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<i){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
