package com.leetcode;

import java.util.HashSet;

public class leetcode5161 {
    public static void main(String[] args) {

    }
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strs=text.split(" ");
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        int res=strs.length;
        for(String str:strs){
            for(int i=0;i<str.length();i++){
                if(set.contains(str.charAt(i))){
                    --res;
                    break;
                }
            }
        }
        return res;
    }
}
