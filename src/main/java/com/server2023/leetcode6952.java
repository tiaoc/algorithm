package com.server2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode6952 {
    public static void main(String[] args) {
        System.out.println(new leetcode6952().countInterestingSubarrays(Arrays.asList(3,2,4), 2, 1));
    }

    // 连续子数组，删掉原来的单个的数组对新的数组的影响
    // 前缀和+两数之和哈希表
    // cnt = s[R] -s[L] cnt = 子数组的元素和。
    // 遍历s[R]算到 s[L]
    // 枚举R，找有多少个数 s[L] % m； 当前数是R，找前面出现过的s[L]%m对应的出现个数
    // (s[R] -s[L]) % m = k    因为满足这个式子，所以可以化简前缀和的公式，通过两数之和做，不需要遍历两重。
    // s[R] % m -s[L]% m = k
    // (s[R]%m - k + m) % m= s[L] % m    当前和之前的对应关系，当前的R对应之前哪个L
    //

    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cur = 0;
        // 前面出现的使得cur-k也满足条件的子数组的量。
        // 只考虑满足余mod成立时增加的子数组的个数
        for (int num : nums) {
            cur += num % mod == k ? 1 : 0;
            cur %= mod;
            int pre = (cur - k + mod) % mod;// 往前追一个mod
            if (map.containsKey(pre)) {
                res += map.get(pre);
            }
            // 新的数组
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}
