package com.server2023;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode6293 {
    //值相同的组有k个
    //找到这些组，然后把它们连续起来
    //找后面的,一段距离
    //统计子数组的重复数字的数量
    public static void main(String[] args) {
        System.out.println(new leetcode6293().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }

    // 移动左端点，左端点及之前的都是好子数组的左端点
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0;
        // 当前对数
        int pairs = 0;
        long res = 0;
        // left右移，导致好数组的数量减少 cnt.get(nums[left]) - 1
        for (int num : nums) {
            pairs += cnt.getOrDefault(num, 0);
            cnt.putIfAbsent(num, 0);
            cnt.put(num, cnt.get(num) + 1);
            while (pairs - cnt.get(nums[left]) + 1 >= k) {
                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                pairs -= cnt.get(nums[left]);
                left++;
            }
            if (pairs >= k) {
                res += left + 1;
            }
        }
        return res;
    }

    public long countGood2(int[] nums, int k) {
        int n = nums.length;
        int[][] pos = new int[n][n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            int v = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    v++;
                }
                pos[i][j] = v;
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                count += pos[j][i];
                if (count >= k) {
                    res++;
                }
            }
        }
        return res;
    }
}
