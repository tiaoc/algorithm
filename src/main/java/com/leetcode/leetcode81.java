package com.leetcode;

import java.util.Arrays;

public class leetcode81 {
    public static void main(String[] args) {
        System.out.println(new leetcode81().search(new int[]{1,0,1,1,1}, 0));
    }
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if(nums[left] ==nums[mid] &&nums[mid]==nums[right]){
                ++left;
                --right;
            }else if (nums[mid] >= nums[left]) {
                // left到mid无旋转
                if (nums[left] <= target && nums[mid] > target) {
                    // left到mid增序
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // left到mid有旋转，mid到right无旋转
                if (nums[right] >= target && nums[mid] < target) {
                    // mid到right减序
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
