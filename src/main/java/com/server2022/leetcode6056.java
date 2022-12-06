package com.server2022;

public class leetcode6056 {
    public String largestGoodInteger(String num) {
        String res = "0";
        char last = num.charAt(0);
        int count = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == last) {
                if (++count == 3) {
                    if (Integer.parseInt(num.substring(i - 2, i + 1)) >= Integer.parseInt(res)) {
                        res = num.substring(i - 2, i + 1);
                    }
                }
            } else {
                count = 1;
                last = num.charAt(i);
            }
        }
        return res.equals("0") ? "" : res;
    }
}
