package com.leetcode;

import java.util.Arrays;

public class leetcode825 {
    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{101,98,80,20,1,97,3,77,114,109}));
    }

    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0, right = 0, count = 0;
        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];
            while (ages[left] <= x / 2 + 7) {
                left++;
            }
            while (right < ages.length && ages[right] <= x) {
                right++;
            }
            System.out.println(left+" "+right);
            if (right > left) {
                count += right - left - 1;
            }
        }
        return count;
    }
}
