package com.server2022;

import java.util.*;

public class leetcode6037 {
    public static void main(String[] args) {
        System.out.println(new leetcode6037().largestInteger(65875));
    }

    public int largestInteger(int num) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int cur = num;
        while (cur > 0) {
            int mod = cur % 10;
            if (mod % 2 == 0) {
                even.add(mod);
            } else {
                odd.add(mod);
            }
            cur /= 10;
        }
        even.sort(Comparator.comparingInt(a->a));
        odd.sort(Comparator.comparingInt(a->a));
        int res = 0, pow = 1;
        while (num > 0) {
            int mod = num % 10;
            num /= 10;
            if (mod % 2 == 0) {
                int t = even.get(0);
                res += t * pow;
                even.remove(0);
            } else {
                int t = odd.get(0);
                res += t * pow;
                odd.remove(0);
            }
            pow *= 10;
        }
        return res;
    }
}
