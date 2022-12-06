package com.leetcode;

public class leetcode6253 {
    public boolean isCircularSentence(String sentence) {
        char a = sentence.charAt(0);
        String[] words = sentence.split(" ");
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            if (pre.charAt(pre.length() - 1) != cur.charAt(0)) {
                return false;
            }
        }
        String last = words[words.length - 1];
        if (words[0].charAt(0) == last.charAt(last.length() - 1)) {
            return true;
        }
        return false;
    }
}
