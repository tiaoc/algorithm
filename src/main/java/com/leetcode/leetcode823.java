package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode823 {

    // 找出乘积组，乘积组还可以向上挂载，组成新树，可以选择挂载或者不挂载
    // dp？a×b要得到c，从小到大，大的选择接或者不接小的。
    // 根为x的位置，存在多少个树的情况
    // 用map存小号节点树的个数并检查对应乘数树的个数
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007, n = arr.length;
        long[] dp = new long[n];
        Arrays.sort(arr);
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] / 2) {
                    break;
                }
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    int idx = map.get(arr[i] / arr[j]);
                    dp[i] += (dp[idx] * dp[j]) % mod;
                    dp[i] %= mod;
                }
            }
            map.put(arr[i], i);
            res += dp[i];
            res %= mod;
        }
        return res;
    }
}
