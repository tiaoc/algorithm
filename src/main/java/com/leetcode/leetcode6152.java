package com.leetcode;

public class leetcode6152 {
    public static void main(String[] args) {
        System.out.println(new leetcode6152().minNumberOfHours(5,3, new int[]{1,4,3,2}, new int[]{2,6,3,1}));
    }
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int e = 0, p = initialExperience, pm = 0;
        for (int i = 0; i < n; i++) {
            e -= energy[i];
            if (p <= experience[i]) {
                pm += experience[i] - p + 1;
                p = experience[i] + 1;
            }
            p += experience[i];
        }
        int times = initialEnergy + e > 0 ? 0 : -initialEnergy - e + 1;
        times += pm;
        return times;
    }
}
