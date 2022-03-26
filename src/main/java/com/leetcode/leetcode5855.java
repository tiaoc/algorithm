package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode5855 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }
            int i=0;
            while(i<a.length()&&a.charAt(i)==b.charAt(i)){
                i++;
            }
            if(i<a.length()){
                return a.charAt(i)-b.charAt(i);
            }
            return 0;
        });
        return nums[nums.length-k];
    }
}
