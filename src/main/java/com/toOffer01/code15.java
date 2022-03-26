package com.toOffer01;

public class code15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-5));
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count=0;
        for (int i=0;i<32;i++) {
            if ((n & 1)>0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
