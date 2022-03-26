package com.leetcode;

public class leetcode6012 {
    //13579 02468
    public static void main(String[] args) {
        System.out.println(new leetcode6012().countEven(30));
    }
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int temp = i, sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
