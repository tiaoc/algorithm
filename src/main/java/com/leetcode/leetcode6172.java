package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode6172 {
    public static void main(String[] args) {
        System.out.println(new leetcode6172().isStrictlyPalindromic(9));
    }
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            int num = n;
            List<Integer> l = new ArrayList<>();
            while (num > 0) {
                int t = num / i;
                l.add(num % i);
                num = t;
            }
            for (int j = 0; j < l.size(); j++) {
                if (!l.get(j).equals(l.get(l.size() - j - 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
