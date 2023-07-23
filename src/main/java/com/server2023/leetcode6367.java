package com.server2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode6367 {
    /**
     * 有k个对，查看0到k，对应最大的。
     * left < right  二分，
     * （1）left=mid+1，right=mid ---- mid = (left + right) >>> 1;
     * （2）left=mid，right=mid-1 ---- mid = (left + right + 1) >>> 1;
     * 本题得用第二种，因为mid满足check时，右边可能都不满足，左边必定都满足
     * mid不满足check时，满足的必定在mid左边。
     *
     * @param nums
     * @return
     */
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length / 2;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * 2;
    }

    private boolean check(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[nums.length - k + i]) {
                return false;
            }
        }
        return true;
    }

    public int maxNumOfMarkedIndices2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //从小到大
        Queue<Integer> left = new LinkedList<>();
        //从小到大
        Queue<Integer> right = new LinkedList<>();
        for (int i = 0; i < n / 2; i++) {
            left.offer(nums[i]);
        }
        for (int i = n / 2; i < n; i++) {
            right.offer(nums[i]);
        }
        int count = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            int little = left.poll();
            while (!right.isEmpty() && right.peek() < little * 2) {
                right.poll();
            }
            if (!right.isEmpty()) {
                right.poll();
                count++;
            }
        }
        return count * 2;
    }
}
