package com.server2022;

public class Leetcode6070 {
    public static void main(String[] args) {
        System.out.println(new Leetcode6070().digitSum("11111222223", 3));
    }

    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            StringBuilder newSb = new StringBuilder();
            int i = 0;
            while (i < sb.length()) {
                int num = 0;
                for (int j = 0; j < k; j++) {
                    if (i == sb.length()) {
                        break;
                    }
                    num += sb.charAt(i) - '0';
                    i++;
                }
                newSb.append(num);
            }
            sb = newSb;
        }
        return sb.toString();
    }
}
