package com.leetcode;

public class leetcode5846 {
    //左=右
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] + nums[j + 1];
        }
        for(int i=0;i<n;i++){
            if(left[i]==right[i]){
                return i;
            }
        }
        return -1;
    }
}
