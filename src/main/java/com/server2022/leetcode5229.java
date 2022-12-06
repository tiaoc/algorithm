package com.server2022;

import java.util.Arrays;

public class leetcode5229 {
    //滑动窗口，找同样大小的窗口，前缀和？前缀和表示x-y的差值，不一定是取sum大的小
    //也可能是取sum小的为原始数组，取决于拿到的diff
    public static void main(String[] args) {
        System.out.println(maximumsSplicedArray(new int[]{20, 40, 20, 70, 30}, new int[]{50, 20, 50, 40, 20}));
    }

    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr1[i] = nums1[i] - nums2[i];
            arr2[i] = nums2[i] - nums1[i];
        }
        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
        int a = findMaxSeq(arr1);
        int b = findMaxSeq(arr2);
        return Math.max(sum1 + b, sum2 + a);
    }

    private static int findMaxSeq(int[] arr) {
        int max = 0, cur = 0;
        for (int j : arr) {
            cur = Math.max(0, cur + j);
            max = Math.max(max, cur);
        }
        return max;
    }
}
