package com.server2022;

import java.util.*;

public class leetcode6049 {
    public static void main(String[] args) {

        String s = "aa";
        System.out.println(s.intern());
    }

    //组合数，连续数组，dfs
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            List<Integer> l = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                l.add(nums[j]);
                set.add(new ArrayList<>(l));
            }
        }
        return set.size();
    }
}
