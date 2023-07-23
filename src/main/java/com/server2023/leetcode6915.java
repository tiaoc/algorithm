package com.server2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode6915 {
    //合并数字，让右边的数字大，合掉所有左边的
    public long maxArrayValue(int[] nums) {
        long[] arr = Arrays.stream(nums).mapToLong(n -> (long) n).toArray();
        int cur = arr.length - 1;
        while (cur > 0) {
            if (arr[cur] >= arr[cur - 1]) {
                arr[cur - 1] += arr[cur];
            }
            cur--;
        }
        return arr[0];
    }
}
