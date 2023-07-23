package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode970 {
    public static void main(String[] args) {
        System.out.println(new leetcode970().powerfulIntegers(3,5,15));
    }
    // x的多次方，y的多次方的和。记录每个次方，加起来，二分找到最大的gx，gy，然后把里面的值循环加。
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int gx = binarySearch(x, bound);
        int gy = binarySearch(y, bound);
        System.out.println(gx);
        System.out.println(gy);
        List<Integer> lx = new ArrayList<>();
        for (int i = 0; i <= gx; i++) {
            lx.add((int) Math.pow(x, i));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= gy; i++) {
            int cur = (int) Math.pow(y, i);
            for (int j = 0; j < lx.size(); j++) {
                int v = cur + lx.get(j);
                if (v > bound) {
                    break;
                } else {
                    set.add(v);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public int binarySearch(int num, int bound) {
        if (num == 1) {
            return 0;
        }
        int left = 0, right = bound;
        while (left < right) {
            int mid = (left + right) / 2;
            if (Math.pow(num, mid) <= bound) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
