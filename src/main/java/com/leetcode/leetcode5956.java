package com.leetcode;

public class leetcode5956 {
    public String firstPalindrome(String[] words) {
        for(String word :words){
            if(isPadinrom(word)){
                return word;
            }
        }
        return "";
    }
    private boolean isPadinrom(String word) {
        int left=0,right=word.length()-1;
        boolean res=true;
        while(left<right) {
            if(word.charAt(left++)!=word.charAt(right--)){
                res=false;
            }
        }
        return res;
    }
}
