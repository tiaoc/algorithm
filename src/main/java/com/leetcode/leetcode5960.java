package com.leetcode;

public class leetcode5960 {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            s[i]=s[i].toLowerCase();
            if (s[i].length() >2) {
                s[i]= s[i].substring(0,1).toUpperCase() + s[i].substring(1);
            }
            sb.append(s[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
