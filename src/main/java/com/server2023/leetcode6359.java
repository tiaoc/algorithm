package com.server2023;

import java.util.*;

public class leetcode6359 {

    public static void main(String[] args) {
        System.out.println(new leetcode6359().distance(new int[]{1,3,1,1,2}));
    }

    // leetcode6359 等值距离和
    // 原数组中值相同的距离之和
    // 一个map，key是值，value是idx list
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Long> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);

            sumMap.putIfAbsent(nums[i], 0L);
            sumMap.put(nums[i], sumMap.get(nums[i]) + i);
        }
        long[] arr = new long[nums.length];
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> list = e.getValue();
            int idxCount = list.size();
            long sum = sumMap.get(e.getKey());
            int lastIdx = list.get(0);
            long rightSum = sum - (long) lastIdx * idxCount;
            long leftSum = 0;
            arr[lastIdx] = rightSum;
            for (int i = 1; i < list.size(); i++) {
                int idx = list.get(i);
                int gap = idx - lastIdx;
                rightSum -= (long) gap * (idxCount - i);
                leftSum += (long) gap * i;
                arr[idx] = leftSum + rightSum;
                lastIdx = idx;
            }
        }
        return arr;
    }

    // leetcode6361
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getRes(nums[i][i]));
            res = Math.max(res, getRes(nums[i][nums.length - i - 1]));
        }
        return res;
    }

    private int getRes(int v) {
        boolean flag = false;
        for (int j = 2; j <= Math.sqrt(v); j++) {
            if (v % j == 0) {
                flag = true;
                break;
            }
        }
        if (!flag && v != 1) {
            return v;
        }
        return 0;
    }

}
