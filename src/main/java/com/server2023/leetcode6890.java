package com.server2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class leetcode6890 {
    // 变成同一个数
    // 延迟增加
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        int lBound = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[lBound] + k < nums[i] - k) {
                lBound++;
            }
            res = Math.max(res, i - lBound + 1);
        }
        return res;
    }

    public int maximumBeauty2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            for (int i = 0; i <= k; i++) {
                int v1 = n + i;
                map.putIfAbsent(v1, 0);
                int r = map.get(v1) + 1;
                map.put(v1, r);
                res = Math.max(res, r);
                int v2 = n - i;
                if (v2 > 0 && v2 != v1) {
                    map.putIfAbsent(v2, 0);
                    r = map.get(v2) + 1;
                    map.put(v2, r);
                    res = Math.max(res, r);
                }
            }
        }
        return res;
    }
}
