package com.leetcode;

public class leetcode5910 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int [] count = new int[26];
        for (int i=0;i<word1.length();i++){
            count[word1.charAt(i)-'a']++;
        }
        for (int i=0;i<word2.length();i++){
            count[word2.charAt(i)-'a']--;
        }
        for( int i=0;i<count.length;i++){
            if(count[i]>3|| count[i]<-3){
                return false;
            }
        }
        return true;
    }
}
