package com.toOffer01;

public class code17 {
    public int[] printNumbers(int n) {
        int[] result = {};
        if (n == 0) return result;
        int maxn = 10;
        while (n > 1) {
            maxn *= 10;
            n--;
        }
        result=new int[maxn-1];
        int i = 0;
        while (i!=maxn-1) {
            result[i] =i+1;
            i++;
        }
        return result;
    }
}
