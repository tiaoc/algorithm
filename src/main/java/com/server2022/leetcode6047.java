package com.server2022;

public class leetcode6047 {
    public String removeDigit(String number, char digit) {
        String v = "0";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                if (compare(sb.toString(), v)) {
                    v = sb.toString();
                }
            }
        }
        return v;
    }

    private boolean compare(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return true;
            }else if(a.charAt(i) < b.charAt(i)){
                return false;
            }
        }
        return false;
    }
}
