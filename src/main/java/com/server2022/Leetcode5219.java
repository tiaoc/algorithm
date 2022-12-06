package com.server2022;

import java.util.Arrays;

public class Leetcode5219 {
    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{5, 6, 4, 10, 10, 1, 1, 2, 2, 2}, 9));
    }

    //二分法
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int c : candies) {
            sum += c;
        }
        if (sum < k){
            return 0;
        }
        Arrays.sort(candies);
        int left = 1, right = candies[candies.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                return 0;
            }
            if (check(mid, candies, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static boolean check(int cur, int[] candies, long k) {
        long count = 0;
        for (int c : candies) {
            count += c / cur;
        }
        return count >= k;
    }
}
