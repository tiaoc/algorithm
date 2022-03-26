package com.leetcode;

import java.util.Arrays;

public class dptest {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,10,4,55,6,3,2,6,7};
        System.out.println(purchasePlans(nums,50));
        System.out.println(purchasePlans2(nums,50));
        nums=new int[]{2,2,1,9};
        System.out.println(purchasePlans(nums,10));
        System.out.println(purchasePlans2(nums,10));
    }

    public static int purchasePlans(int[] nums, int target) {
        int n = nums.length;
        int[]dp = new int[target + 1];
        long max = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num < target) {
                dp[num]++;
            } else {
                break;
            }
        }
        int[] add=new int[target+1];
        for (int i = 1; i <=target ; i++) {
            add[i]=add[i-1]+dp[i];
        }
        for (int i = 0; i <=target; i++) {
            int temp=add[target-i]-add[0];
            if(dp[i]>0) {
                if (target - i >=i) {
                    max += dp[i] * (temp-1);
                }else{
                    max += dp[i] * temp;
                }
            }
        }
        return (int)max>>1%1000000007;
    }

    public static int purchasePlans2(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[target + 1][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < target) {
                dp[nums[i]][0]++;
            }
            for (int j = nums[i] + 1; j <= target; j++) {
                dp[j][1] += dp[j - nums[i]][0];
                if (j - nums[i] == nums[i]) {
                    dp[j][1]--;
                }
            }
        }
        for (int i = 0; i < target + 1; i++) {
            max += dp[i][1];
            max %= 1000000007;
        }
        return max;
    }
}
