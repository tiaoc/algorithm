package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class leetcode5217 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9})));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{map(nums[i], mapping), i};
        }
        System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        return Arrays.stream(arr).map(item -> nums[item[1]]).mapToInt(Integer::valueOf).toArray();
    }

    private static int map(int num, int[] mapping) {
        int digit = num % 10;
        int ret = mapping[digit];
        int count = 1;
        num/=10;
        while (num > 0) {
            digit = num % 10;
            ret = (int) (ret + mapping[digit] * Math.pow(10, count));
            num /= 10;
            count++;
        }
        return ret;
    }
}
