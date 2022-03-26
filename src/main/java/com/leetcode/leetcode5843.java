package com.leetcode;

public class leetcode5843 {
    public int numOfStrings(String[] patterns, String word) {
        int res=0;
        for(String s:patterns){
            if(word.contains(s)){
                res++;
            }
        }
        return res;
    }
}
