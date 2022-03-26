package com.leetcode;

public class leetcode6027 {
    public int countHillValley(int[] nums) {
        int state = -2,count=0;
        for (int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                if(state == -1){
                    count++;
                }
                state = 1;
            }else if (nums[i]<nums[i-1]){
                if(state == 1){
                    count++;
                }
                state = -1;
            }
        }
        return count;
    }
}
