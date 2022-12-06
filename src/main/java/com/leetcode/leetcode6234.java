package com.leetcode;

public class leetcode6234 {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            }
            int pastLcm = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int v = getLcm(nums[j], pastLcm);
                pastLcm = v;
                if (v > k) {
                    break;
                } else if (v == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getGcd(int m, int n) {
        while (n > 0) {
            int t = m % n;
            m = n;
            n = t;
        }
        return m;
    }

    //求解数m和n和最小公倍数
    public int getLcm(int m, int n) {
        int gcd = getGcd(m,n);
        return m*n/gcd;
    }

}
