package com.server2022;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode5268 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for (int num : set1) {
            if (!set2.contains(num)) {
                ans1.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                ans2.add(num);
            }
        }
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
