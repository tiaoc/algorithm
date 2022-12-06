package com.server2022;

public class Leetcode5236 {
    // 后一个不等于前一个,前一个是偶数
    // 偶数位不等于它的下一个值
    public static void main(String[] args) {
        System.out.println(minDeletion(new int[]{2, 6, 2, 5, 8, 9, 7, 2, 2, 5, 6, 2, 2, 0, 6, 8, 7, 3, 9, 2, 1, 1, 3, 2, 6, 2, 4, 6, 5, 8, 4, 8, 7, 0, 4,
                8, 7, 8, 4, 1, 1, 4, 0, 1, 5, 7, 7, 5, 9, 7, 5, 5, 8, 6, 4, 3, 6, 5, 1, 6, 7, 6, 9, 9, 6, 8, 6, 0, 9, 5, 6, 7, 6, 9, 5, 5, 7, 3, 0, 0, 5, 5, 4, 8, 3, 9, 3, 4, 1, 7, 9, 3, 1, 8, 8, 9, 1, 6, 0, 0}));
    }

    public static int minDeletion(int[] nums) {
        int cur = 0, del = 0;
        boolean even = false;
        for (int i = 0; i < nums.length; i++) {
            if (even) {
                if (nums[cur] == nums[i]) {
                    del++;
                    if (i == nums.length - 1) {
                        del++;
                    }
                } else {
                    even = false;
                }
            } else {
                cur = i;
                if (cur == nums.length - 1) {
                    del++;
                }
                even = true;
            }
        }
        return del;
    }
}
