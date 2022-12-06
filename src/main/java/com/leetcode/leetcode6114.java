package com.leetcode;

public class leetcode6114 {
    // LR的相对顺序相同,且left只能向左，right只能向右
    // 按顺序考虑L和R，L左边（距目标点位）都是_才行
    //
    public static void main(String[] args) {
        System.out.println(canChange("_L", "LL"));
    }

    public static boolean canChange(String start, String target) {
        int origin = 0, sink = 0, n = start.length();
        while (origin < n || sink < n) {
            while (origin < n && start.charAt(origin) == '_') {
                ++origin;
            }
            while (sink < n && target.charAt(sink) == '_') {
                ++sink;
            }
            if (origin == n && sink != n || origin != n && sink == n) {
                return false;
            }
            if (origin == n) {
                return true;
            }
            char c = start.charAt(origin);
            if (c != target.charAt(sink)) {
                return false;
            }
            if (c == 'L') {
                if (origin < sink) {
                    return false;
                }
            } else {
                if (origin > sink) {
                    return false;
                }
            }
            ++origin;
            ++sink;
        }
        return true;
    }
}
