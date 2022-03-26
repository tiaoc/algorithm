package com.leetcode;

import java.util.Arrays;

public class leetcode5808 {
    public static void main(String[] args) {

    }
    public int[] getConcatenation(int[] nums) {
        int[] ans=new int[nums.length*2];
        System.arraycopy(nums,0,ans,0,nums.length);
        System.arraycopy(nums,0,ans,nums.length,nums.length);
        return ans;
    }
}
