package com.toOffer01;

public class code16_myPow {
    public static void main(String[] args) {
        System.out.println(myPow(3, 3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        long b = n;
        if (b < 0) {//考虑n<0的情况
            x = 1 / x;
            b = -b;
        }
        double result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return result;
    }
}
