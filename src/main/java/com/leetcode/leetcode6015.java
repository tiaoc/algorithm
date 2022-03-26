package com.leetcode;

public class leetcode6015 {
    public long coutPairs(int[] nums, int k) {
        long res=0, sk=0;
        for (int i =0;i<nums.length;i++){
            if(nums[i] % k==0){
                sk++;
            }
        }
        if(sk>1) {
            return sk * (nums.length - 1) - (sk - 1) * (sk - 1);
        }else if(sk ==1){
            return sk * (nums.length - 1);
        }
        return 0;
    }
}
