package com.leetcode;


import java.util.Arrays;

public class leetcode6254 {
    // 两数组合，乘积相同，和为
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long v = (long) skill[0] * skill[skill.length - 1];
        int s = skill[0] + skill[skill.length - 1];
        for (int i = 1; i < skill.length / 2; i++) {
            if (skill[i] + skill[skill.length - i - 1] != s) {
                return -1;
            }
            v += (long) skill[i] * skill[skill.length - i - 1];
        }
        return v;
    }
}
