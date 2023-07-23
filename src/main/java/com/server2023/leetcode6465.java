package com.server2023;

public class leetcode6465 {
    // aaaa ---- aaaz
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (start) {
                    sb.append(s.substring(i));
                    break;
                }
                sb.append(s.charAt(i));
                continue;
            }
            if (!start) {
                start = true;
            }
            sb.append((char) (s.charAt(i) - 1));
        }
        if (!start) {
            sb.deleteCharAt(sb.length() - 1);
            sb.append('z');
        }
        return sb.toString();
    }
}
