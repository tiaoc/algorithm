package com.leetcode;

public class leetcode5867 {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                sb.append(word.substring(0, i + 1));
                sb = sb.reverse();
                sb.append(word.substring(i + 1));
                break;
            }
        }
        if (sb.length() == 0) {
            return word;
        }
        return sb.toString();
    }
}
