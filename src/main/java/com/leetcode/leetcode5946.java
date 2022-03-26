package com.leetcode;

public class leetcode5946 {
    public int mostWordsFound(String[] sentences) {
        int v=0;
        for (String sentence :sentences){
            v=Math.max(v,sentence.split(" ").length);
        }
        return v;
    }
}
