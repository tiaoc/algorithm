package com.server2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class leetcode8040 {
    public static void main(String[] args) {
        System.out.println(new leetcode8040().minimumOperations("25"));
    }

    // 25 50 75 00 结尾的数字，可以删成0
    public int minimumOperations(String num) {
        int start = 0, del = 0;
        int a = minimum(num, 0, 0);
        int b = minimum(num, 2, 5);
        int c = minimum(num, 5, 0);
        int d = minimum(num, 7, 5);
        return Stream.of(a, b, c, d).min(Comparator.comparingInt(o -> o)).get();
    }

    public int minimum(String num, int a, int b) {
        int start = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (start == -1 && num.charAt(i) - '0' == b) {
                start = i;
            } else if (start > 0 && num.charAt(i) - '0' == a) {
                return num.length() - i - 2;
            }
        }
        int res = num.length();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                res--;
            }
        }
        return res;
    }
}
