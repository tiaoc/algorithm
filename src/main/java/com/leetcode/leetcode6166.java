package com.leetcode;

public class leetcode6166 {
    // 找双字对 逆填充，剩下的找一个填充中间
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && sb.length() == 0) {
                break;
            }
            int t = arr[i] / 2;
            sb.append(String.valueOf(i).repeat(Math.max(0, t)));
        }
        boolean f = false;
        for (int i = 9; i >= 0; i--) {
            int t = arr[i] % 2;
            if (t != 0) {
                sb.append(i);
                f = true;
                break;
            }
        }
        if (sb.length() == 0) {
            sb.append(0);
            f = true;
        }
        if (f) {
            sb.append(new StringBuilder(sb.substring(0, sb.length() - 1)).reverse());
        } else {
            sb.append(sb.reverse());
        }
        return sb.toString();
    }
}
