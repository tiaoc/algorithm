package com.server2023;

public class leetcode6424 {
    // 1的位置，n的位置，1到idx0的距离，n到idxn的距离
    //
    public int semiOrderedPermutation(int[] nums) {
        int idx1 = 0;
        int idxn = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                idx1 = i;
            }
            if (nums[i] == nums.length) {
                idxn = i;
            }
        }
        if (idx1 < idxn) {
            return idx1 + (nums.length - 1 - idxn);
        }
        return idx1 + (nums.length - 1 - idxn) - 1;
    }
}
