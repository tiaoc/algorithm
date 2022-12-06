package com.leetcode;

import java.util.Arrays;

public class leetcode6121 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            String[][] arr = new String[nums.length][2];
            for (int j = 0; j < nums.length; j++) {
                arr[j] = new String[]{nums[j].substring(nums[0].length() - trim), Integer.toString(j)};
            }
            Arrays.sort(arr, (a, b) -> {
                for (int idx = 0; idx < a[0].length(); idx++) {
                    if (a[0].charAt(idx) > b[0].charAt(idx)) {
                        return 1;
                    } else if (a[0].charAt(idx) < b[0].charAt(idx)) {
                        return -1;
                    }
                }
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            });
            res[i] = Integer.parseInt(arr[k - 1][1]);
        }
        return res;
    }
}
