package com.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class leetcode6159 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,6,1};
        int[] n2 = new int[]{0,3,2,4,1};
        System.out.println( new leetcode6159().maximumSegmentSum(nums, n2));
    }
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                return 0;
            }
            return a[2] - b[2] < 0 ? 1 : -1;
        });
        long v = 0;
        for (int j = 0; j < nums.length; j++) {
            v += nums[j];
        }
        q.offer(new long[]{0, nums.length - 1, v});
        long[] res = new long[removeQueries.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < removeQueries.length; i++) {
            int num = removeQueries[i];
            set.add(num);
            if (q.isEmpty()) {
                res[i] = 0;
                continue;
            }
            if (q.peek()[0] > num || q.peek()[1] < num) {
                res[i] = q.peek()[2];
                continue;
            }
            boolean f = true;
            while (f) {
                f = false;
                if (q.isEmpty()) {
                    break;
                }
                Integer[] arr = set.toArray(new Integer[0]);
                for (int nu : arr) {
                    if (q.peek()[0] <= nu && q.peek()[1] >= nu) {
                        long[] cur = q.poll();
                        long v2 = 0;
                        for (int j = (int) cur[0]; j < nu; j++) {
                            v2 += nums[j];
                        }
                        if (cur[0] != nu) {
                            q.offer(new long[]{cur[0], nu, v2});
                        }
                        if (cur[1] != nu) {
                            q.offer(new long[]{nu + 1, cur[1], cur[2] - v2 - nums[nu]});
                        }
                        set.remove(nu);
                        f = true;
                        break;
                    }
                }
            }
            if (!q.isEmpty()) {
                res[i] = q.peek()[2];
            }
        }
        return res;
    }
}
