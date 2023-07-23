package com.leetcode;


public class leetcode215 {
    public static void main(String[] args) {
        System.out.println(new leetcode215().findKthLargest(new int[]{7,6,5,4,3,2,1}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return partition(0, nums.length - 1, nums, nums.length - k);
    }

    public int partition(int start, int end, int[] nums, int k) {
        int i = start + 1;
        int j = end;
        int pivot = nums[start];
        while (i < j) {
            while (i < j && nums[i] < pivot) {
                i++;
            }
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if(i<j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, start, i);
        if (i == k) {
            return pivot;
        } else if (k < j) {
            return partition(start, i - 1, nums, k);
        } else {
            return partition(i + 1, end, nums, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
