package com.leetcode;

public class leetcode5902 {
    public boolean areNumbersAscending(String s) {
        int pre = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cur = cur * 10 + s.charAt(i) - '0';
                    i++;
                }
                System.out.println(cur);
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
                cur = 0;
            }
        }
        return true;
    }
}
