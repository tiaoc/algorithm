package com.server2023;

public class leetcode7020 {

    public static void main(String[] args) {
        System.out.println(new leetcode7020().countSymmetricIntegers(9999,10000));
    }
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            if (i < 100) {
                if (i / 10 == i % 10) {
                    res++;
                }
            } else if (i > 1000 && i < 10000) {
                int left = 0, right = 0;
                int cur = i;
                right += cur % 10;
                cur /= 10;
                right += cur % 10;
                cur /= 10;
                left += cur % 10;
                cur /= 10;
                left += cur % 10;
                if (left == right) {
                    res++;
                }
            }
        }
        return res;
    }
}
