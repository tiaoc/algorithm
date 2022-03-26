package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class leetcode5942 {
    //数组中至少含有一位偶数
    //找出三元组，通过三元组构建排列
    //遍历三元组，100*100*100
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            int di = digits[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int dj = di * 10 + digits[j];
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    int dk = dj * 10 + digits[k];
                    if (digits[k] % 2 == 0 && !set.contains(dk)) {
                        set.add(dk);
                        list.add(dk);
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
