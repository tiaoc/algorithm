package com.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode659 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4, 5};
        System.out.println(isPossible(nums));
    }

    public static boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1) && !map.get(num - 1).isEmpty()) {
                int preLen = map.get(num - 1).poll();
                map.get(num).offer(preLen + 1);
            } else {
                map.get(num).offer(1);
            }
        }
        for (int num : nums) {
            if (map.containsKey(num) && !map.get(num).isEmpty() && map.get(num).peek() < 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPossible2(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            if (count <= 0) {
                continue;
            }
            int preEndCount = endMap.getOrDefault(num - 1, 0);
            if (preEndCount > 0) {
                countMap.put(num, count - 1);
                endMap.put(num - 1, preEndCount - 1);
                endMap.put(num, endMap.getOrDefault(num, 0) + 1);
            } else {
                int count1 = countMap.getOrDefault(num + 1, 0);
                int count2 = countMap.getOrDefault(num + 2, 0);
                if (count1 > 0 && count2 > 0) {
                    countMap.put(num,count-1);
                    countMap.put(num + 1, count1 - 1);
                    countMap.put(num + 2, count2 - 1);
                    endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
