package com.server2022;

public class leetcode6109 {
    public static void main(String[] args) {
        System.out.println(new leetcode6109().peopleAwareOfSecret(6, 2, 4));
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        double d = 0.01;
        double e = 0.01;
        System.out.println(Double.compare(d,e));
        int mod = 1000000007;
        int[] people = new int[forget];
        people[0] = 1;
        for (int i = 1; i < n; i++) {
            int newPeople = 0;
            // 滑窗优化
            for (int j = Math.min(forget - 1, n); j > 0; j--) {
                people[j] = people[j - 1];
            }
            for (int j = delay; j < forget; j++) {
                newPeople = (newPeople + people[j]) % mod;
            }
            people[0] = newPeople;
        }
        int res = 0;
        for (int i = 0; i < forget; i++) {
            res = (res + people[i]) % mod;
        }
        return res;
    }
}
