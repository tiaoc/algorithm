package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode6164 {
    //相等&&idx相加最大
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int key = sum(nums[i]);
            if (map.containsKey(key)) {
                max = Math.max(max, map.get(key) + nums[i]);
            }
            map.put(key, nums[i]);
        }
        return max;
    }

    private int sum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
