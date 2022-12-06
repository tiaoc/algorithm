package com.server2022;

public class leetccode6079 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.charAt(0) != '$') {
                continue;
            }
            double v = 0;
            int j = 1;
            boolean flag = false;
            while (j < s.length()) {
                char c = s.charAt(j++);
                if (c >= '0' && c <= '9') {
                    v = v * 10 + c - '0';
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            v = v * (100 - discount) / 100;
            if (flag) {
                words[i] = '$' + String.format("%.2f", v);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
