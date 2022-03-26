package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode290 {
    public static void main(String[] args) {
        String pat="abba";
        String s="dog cat cat dog";
        System.out.println(wordPattern(pat,s));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        System.out.println(Arrays.toString(words));
        if(words.length!=pattern.length()){
            return false;
        }
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            char cur=pattern.charAt(i);
            if(!map.containsKey(cur)){
                map.put(cur,words[i]);
            }else if (!map.get(cur).equals(words[i])){
                return false;
            }
        }
        return true;
    }
}
